package ru.sport.home.screens.menu

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import ru.sport.common.DbViewModel
import ru.sport.home.R
import ru.sport.home.database.Exercise
import ru.sport.home.database.ExerciseDao
import ru.sport.uikit.ExerciseView
import javax.inject.Inject

class MenuViewModel
@Inject constructor(
    private val exerciseDao: ExerciseDao,
    private val router: IMenuRouter
) : DbViewModel() {

    val exercises = MutableLiveData<List<ExerciseView.ViewModel>>()
    val onRemoveExercise = MutableLiveData<ExerciseView.ViewModel>()
    val addCreateNewExercise = MutableLiveData<CreatorItemModel>()

    init {
        onCreate()
        addCreatorItem()
    }

    private fun addCreatorItem() {
        addCreateNewExercise.value = CreatorItemModel { showCreateScreen() }
    }

    private fun showCreateScreen() {

    }


    private fun onCreate() {
        launch(coroutineContext) {
            val ex = exerciseDao.getAll()
            if (ex.isNullOrEmpty()) { addItemsToDb() } else { mapToViewModel(ex) }
        }
    }

    private fun mapToViewModel(ex: List<Exercise>) {
        val list = ex.map { exercise ->
            ExerciseView.ViewModel(
                exercise.title,
                exercise.description,
                exercise.iconRes,
                { openScreen(it) })
            { onRemoveClick(exercise, it) }
        }
        exercises.postValue(list)
    }

    private fun openScreen(model: ExerciseView.ViewModel) {
        router.openExerciseScreen()
    }

    private fun onRemoveClick(model: Exercise, it: ExerciseView.ViewModel) {
        if (model.isCanRemove) {
            removeItem(model, it)
        } else {
            router.showAlertDialog(R.string.remove_error, R.string.remove_error_message)
        }
    }

    private fun removeItem(model: Exercise, it: ExerciseView.ViewModel) {
        launch {
            exerciseDao.delete(model)
            onRemoveExercise.postValue(it)
        }
    }

    private fun addItemsToDb() {
        launch {
            exerciseDao.insert(
                Exercise(
                    1,
                    R.string.app_name,
                    R.string.push_ups,
                    R.drawable.push_ups,
                    false
                )
            )
            exerciseDao.insert(
                Exercise(
                    2,
                    R.string.push_ups,
                    R.string.app_name,
                    R.drawable.logo,
                    false
                )
            )
            exerciseDao.insert(
                Exercise(
                    3,
                    R.string.app_name,
                    R.string.app_name,
                    R.drawable.ic_launcher_background,
                    false
                )
            )
            exerciseDao.insert(
                Exercise(
                    4,
                    R.string.abs,
                    R.string.app_name,
                    R.drawable.ic_launcher_foreground,
                    false
                )
            )
            onCreate()
        }
    }

    override fun onCleared() {
        super.onCleared()
        cancel()
    }

}

package nl.jordanvanbeijnhem.reminder.repository

import android.content.Context
import androidx.lifecycle.LiveData
import nl.jordanvanbeijnhem.reminder.dao.ReminderDao
import nl.jordanvanbeijnhem.reminder.database.ReminderRoomDatabase
import nl.jordanvanbeijnhem.reminder.model.Reminder

class ReminderRepository(context: Context) {

    private var reminderDao: ReminderDao

    init {
        val reminderRoomDatabase = ReminderRoomDatabase.getDatabase(context)
        reminderDao = reminderRoomDatabase!!.reminderDao()
    }

    fun getAllReminders(): LiveData<List<Reminder>> {
        return reminderDao.getAllReminders()
    }

    suspend fun insertReminder(reminder: Reminder) {
        reminderDao.insertReminder(reminder)
    }

    suspend fun deleteReminder(reminder: Reminder) {
        reminderDao.deleteReminder(reminder)
    }

    suspend fun updateReminder(reminder: Reminder) {
        reminderDao.updateReminder(reminder)
    }
}

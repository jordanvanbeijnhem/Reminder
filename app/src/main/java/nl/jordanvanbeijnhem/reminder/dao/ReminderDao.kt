package nl.jordanvanbeijnhem.reminder.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import nl.jordanvanbeijnhem.reminder.model.Reminder

@Dao
interface ReminderDao {

    @Query("SELECT * FROM reminderTable")
    fun getAllReminders(): LiveData<List<Reminder>>

    @Insert
    suspend fun insertReminder(reminder: Reminder)

    @Delete
    suspend fun deleteReminder(reminder: Reminder)

    @Update
    suspend fun updateReminder(reminder: Reminder)
}

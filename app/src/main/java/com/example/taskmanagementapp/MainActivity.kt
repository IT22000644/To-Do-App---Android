package com.example.taskmanagementapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.taskmanagementapp.database.TaskDatabase
import com.example.taskmanagementapp.repository.TaskRepository
import com.example.taskmanagementapp.viewmodel.TaskViewModel
import com.example.taskmanagementapp.viewmodel.TaskViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var taskViewModel: TaskViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()

    }

    private fun setupViewModel() {
        val taskRepository = TaskRepository(TaskDatabase(this))
        val viewModelProviderFactory = TaskViewModelFactory(application, taskRepository)
        taskViewModel = ViewModelProvider(this, viewModelProviderFactory).get(TaskViewModel::class.java)
    }
}
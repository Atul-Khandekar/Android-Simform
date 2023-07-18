package com.example.shopkart.views

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.example.shopkart.R
import com.example.shopkart.databinding.FragmentGalleryBinding
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class GalleryFragment : Fragment() {

    private lateinit var photoUri: Uri
    private lateinit var binding: FragmentGalleryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentGalleryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnPickImage.setOnClickListener {
                selectImageFromGallery()
            }

            btnOpenCamera.setOnClickListener {
                captureImageFromCamera()
            }
        }
    }

    private val selectImageFromGalleryResult =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let { binding.imageFromGallery.setImageURI(uri) }
        }

    private fun selectImageFromGallery() = selectImageFromGalleryResult.launch("image/*")

    private fun captureImageFromCamera() {
        val photoFile: File = createImageFile()
        photoFile.let {
            photoUri = FileProvider.getUriForFile(
                requireActivity(),
                "${requireActivity().applicationContext.packageName}.fileProvider",
                it
            )

            photoLauncher.launch(photoUri)
        }
    }

    private val photoLauncher =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess  ->
            if (isSuccess) {
                binding.imageFromGallery.setImageURI(photoUri)
            } else {
                Toast.makeText(context, R.string.image_not_found, Toast.LENGTH_LONG).show()
            }
        }

    private fun createImageFile(): File {
        val timeStamp: String =
            SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val storageDir: File? = activity?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("JPEG_${timeStamp}_", ".jpg", storageDir)
    }
}
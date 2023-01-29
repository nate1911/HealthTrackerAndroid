/*
 * Copyright 2022 The TensorFlow Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *             http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.healthtrackerapp.classes

import android.content.Context
import android.os.SystemClock
import org.tensorflow.lite.support.label.Category
import org.tensorflow.lite.task.core.BaseOptions
import org.tensorflow.lite.task.text.nlclassifier.BertNLClassifier
import org.tensorflow.lite.task.text.nlclassifier.NLClassifier
import java.util.concurrent.ScheduledThreadPoolExecutor

class TextClassificationHelper(
    val context: Context,
) {
    // There are two different classifiers here to support both the Average Word Vector
    // model (NLClassifier) and the MobileBERT model (BertNLClassifier). Model selection
    // can be changed from the UI bottom sheet.
    private lateinit var bertClassifier: BertNLClassifier

    private lateinit var executor: ScheduledThreadPoolExecutor

    init {
        initClassifier()
    }

    fun initClassifier() {
        val baseOptionsBuilder = BaseOptions.builder()

        // Use the specified hardware for running the model. Default to CPU.
        // Possible to also use a GPU delegate, but this requires that the classifier be created
        // on the same thread that is using the classifier, which is outside of the scope of this
        // sample's design.

        val baseOptions = baseOptionsBuilder.build()

        // Directions for generating both models can be found at
        // https://www.tensorflow.org/lite/models/modify/model_maker/text_classification
            val options = BertNLClassifier.BertNLClassifierOptions
                .builder()
                .setBaseOptions(baseOptions)
                .build()

            bertClassifier = BertNLClassifier.createFromFileAndOptions(
                context,
                MOBILEBERT,
                options)
    }

    fun classify(text: String, listener: TextResultsListener) {
        executor = ScheduledThreadPoolExecutor(1)

        executor.execute {
            val results: List<Category>
            // inferenceTime is the amount of time, in milliseconds, that it takes to
            // classify the input text.
            var inferenceTime = SystemClock.uptimeMillis()

            // Use the appropriate classifier based on the selected model
                results = bertClassifier.classify(text)

            inferenceTime = SystemClock.uptimeMillis() - inferenceTime

            listener.onResult(results, inferenceTime)
        }
    }

    interface TextResultsListener {
        fun onError(error: String)
        fun onResult(results: List<Category>, inferenceTime: Long)
    }

    companion object {
        const val MOBILEBERT = "mobilebert.tflite"
    }
}
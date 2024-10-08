package com.example.studentportal.grades.usecase.model

import com.example.studentportal.common.usecase.BaseUseCaseModel
import com.example.studentportal.grades.ui.model.GradeUiModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GradeUseCaseModel(
    val id: String,
    val score: Int,
    val studentFirstName: String?,
    val studentLastName: String?,
    val studentId: String,
    val assignmentId: String?,
    val submissionLink: String?
) : BaseUseCaseModel<GradeUiModel> {
    override fun toUiModel(): GradeUiModel {
        return GradeUiModel(
            id = id,
            score = score,
            studentFirstName = studentFirstName ?: "",
            studentLastName = studentLastName ?: "",
            studentId = studentId,
            submissionLink = submissionLink
        )
    }
}

package com.github.pushpavel.autocp.gather.filegen

import com.github.pushpavel.autocp.database.models.Problem
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

class CppFileGenerator(project: Project) : DefaultFileGenerator(project) {
    override fun isSupported(extension: String): Boolean = extension == "cpp"
    override fun getFileNameWithExtension(parentPsiDir: PsiDirectory, problem: Problem, extension: String): String {
        val fileName = defaultConversion(problem.name);
        return "${fileName}.$extension"
    }
}
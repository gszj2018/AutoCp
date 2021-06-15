package gather

import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import database.AutoCpDB
import gather.models.GenerateSolutionsContext
import java.nio.file.Paths
import kotlin.io.path.pathString

fun generateSolutionFiles(project: Project, context: GenerateSolutionsContext) {
    val rootDir = Paths.get(project.basePath!!, context.problems[0].group).toFile()
    rootDir.mkdir()

    val solutionPaths = context.problems.map { Paths.get(rootDir.path, "${it.name}.${context.lang.extension}") }
    solutionPaths.forEach { it.toFile().createNewFile() }

    val service = project.service<AutoCpDB>()
    solutionPaths.zip(context.problems).forEach { service.associateSolutionWithProblem(it.first.pathString, it.second) }
}
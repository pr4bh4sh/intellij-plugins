// Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package training.learn.course

import com.intellij.lang.java.JavaLanguage
import training.learn.LearningModule
import training.learn.LessonsBundle
import training.learn.interfaces.ModuleType
import training.learn.lesson.general.*
import training.learn.lesson.general.assistance.CodeFormatLesson
import training.learn.lesson.general.assistance.ParameterInfoLesson
import training.learn.lesson.general.assistance.QuickPopupsLesson
import training.learn.lesson.general.refactorings.ExtractVariableFromBubbleLesson
import training.learn.lesson.java.assistance.JavaEditorCodingAssistanceLesson
import training.learn.lesson.java.basic.JavaSurroundAndUnwrapLesson
import training.learn.lesson.java.completion.*
import training.learn.lesson.java.navigation.JavaDeclarationAndUsagesLesson
import training.learn.lesson.java.navigation.JavaFileStructureLesson
import training.learn.lesson.java.navigation.JavaInheritanceHierarchyLesson
import training.learn.lesson.java.navigation.JavaOccurrencesLesson
import training.learn.lesson.java.refactorings.JavaExtractMethodCocktailSortLesson
import training.learn.lesson.java.refactorings.JavaRefactoringMenuLesson
import training.learn.lesson.java.refactorings.JavaRenameLesson
import training.learn.lesson.java.run.JavaDebugLesson
import training.learn.lesson.java.run.JavaRunConfigurationLesson

class JavaLearningCourse : LearningCourseBase(JavaLanguage.INSTANCE.id) {
  override fun modules() = listOf(
    LearningModule(name = LessonsBundle.message("editor.basics.module.name"),
                   description = LessonsBundle.message("editor.basics.module.description"),
                   primaryLanguage = langSupport,
                   moduleType = ModuleType.SCRATCH) {
      fun ls(sampleName: String) = loadSample("EditorBasics/$sampleName")
      listOf(
        GotoActionLesson(it, lang, ls("00.Actions.java.sample")),
        SelectLesson(it, lang, ls("01.Select.java.sample")),
        SingleLineCommentLesson(it, lang, ls("02.Comment.java.sample")),
        DuplicateLesson(it, lang, ls("04.Duplicate.java.sample")),
        MoveLesson(it, lang, ls("05.Move.java.sample")),
        CollapseLesson(it, lang, ls("06.Collapse.java.sample")),
        JavaSurroundAndUnwrapLesson(it),
        MultipleSelectionHtmlLesson(it),
      )
    },
    LearningModule(name = LessonsBundle.message("code.completion.module.name"),
                   description = LessonsBundle.message("code.completion.module.description"),
                   primaryLanguage = langSupport,
                   moduleType = ModuleType.SCRATCH) {
      listOf(
        BasicCompletionLesson(it),
        SmartTypeCompletionLesson(it),
        PostfixCompletionLesson(it),
        StatementCompletionLesson(it),
        JavaCompletionWithTabLesson(it),
      )
    },
    LearningModule(name = LessonsBundle.message("refactorings.module.name"),
                   description = LessonsBundle.message("refactorings.module.description"),
                   primaryLanguage = langSupport,
                   moduleType = ModuleType.PROJECT) {
      fun ls(sampleName: String) = loadSample("Refactorings/$sampleName")
      listOf(
        JavaRenameLesson(it),
        ExtractVariableFromBubbleLesson(it, lang, ls("ExtractVariable.java.sample")),
        JavaExtractMethodCocktailSortLesson(it),
        JavaRefactoringMenuLesson(it),
      )
    },
    LearningModule(name = LessonsBundle.message("code.assistance.module.name"),
                   description = LessonsBundle.message("code.assistance.module.description"),
                   primaryLanguage = langSupport,
                   moduleType = ModuleType.PROJECT) {
      fun ls(sampleName: String) = loadSample("CodeAssistance/$sampleName")
      listOf(
        CodeFormatLesson(it, lang, ls("CodeFormat.java.sample")),
        ParameterInfoLesson(it, lang, ls("ParameterInfo.java.sample")),
        QuickPopupsLesson(it, lang, ls("QuickPopups.java.sample")),
        JavaEditorCodingAssistanceLesson(it, lang, ls("EditorCodingAssistance.java.sample")),
      )
    },
    LearningModule(name = LessonsBundle.message("navigation.module.name"),
                   description = LessonsBundle.message("navigation.module.description"),
                   primaryLanguage = langSupport,
                   moduleType = ModuleType.PROJECT) {
      listOf(
        JavaFileStructureLesson(it),
        JavaDeclarationAndUsagesLesson(it),
        JavaInheritanceHierarchyLesson(it),
        JavaOccurrencesLesson(it),
      )
    },
    LearningModule(name = LessonsBundle.message("run.debug.module.name"),
                   description = LessonsBundle.message("run.debug.module.description"),
                   primaryLanguage = langSupport,
                   moduleType = ModuleType.PROJECT) {
      listOf(
        JavaRunConfigurationLesson(it),
        JavaDebugLesson(it),
      )
    },
  )
}
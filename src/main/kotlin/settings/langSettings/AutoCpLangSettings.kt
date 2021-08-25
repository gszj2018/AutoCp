package settings.langSettings

import com.intellij.openapi.components.*
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.fileTypes.UnknownFileType
import com.intellij.openapi.vfs.VirtualFile
import settings.langSettings.model.Lang
import settings.langSettings.model.MutableLang

@State(
    name = "settings.Languages",
    storages = [Storage("autoCpSettings.xml")]
)
@Service
class AutoCpLangSettings : PersistentStateComponent<LangSettings> {

    var languages: Map<String, Lang> = getDefaultLanguages()

    override fun getState(): LangSettings {
        return LangSettings(languages.mapValues { MutableLang(it.value) })
    }


    override fun loadState(state: LangSettings) {
        languages = state.languages.mapValues { Lang(it.value) }
    }

    companion object {

        val instance: AutoCpLangSettings get() = service()

        fun findLangByFile(file: VirtualFile?): Lang? {
            val fileType = file?.fileType ?: return null
            if (fileType is UnknownFileType || fileType !is LanguageFileType)
                return null

            val langId = fileType.language.id

            return instance.languages[langId]
        }
    }
}

data class LangSettings(
    var languages: Map<String, MutableLang> = mapOf()
)
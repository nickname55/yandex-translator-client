import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pampushko.translators.models.SupportedLanguagesResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 */
@DisplayName("Проверка функции определения языка по образцу текста")
public class GetLanguageOfTextTest extends BaseTest
{
	/**
	 * Проверка получения полного наименования языка по коду.
	 * <br />
	 * Например "mi" = "Маори"
	 */
	@Test
	@DisplayName("Проверка получения полного наименования языка по коду")
	public void getFullNameOfLanguageByLanguageCode()
	{
		final String ui = "ru";
		SupportedLanguagesResult supportedLanguagesResultAndDirections = apiClient.getListSupportedLanguages(ui);
		Map<String, String> languages = supportedLanguagesResultAndDirections.getLanguages();
		final String languageCode = "mi";
		String languageDisplayName = languages.get(languageCode);
		assertEquals("Маори", languageDisplayName);
		
	}
	
	/**
	 * Проверка получения доступных направлений перевода
	 * <br />
	 */
	@Test
	@DisplayName("Проверка получения доступных направлений перевода")
	public void getAllTranslateDirections()
	{
		final String ui = "ru";
		SupportedLanguagesResult supportedLanguagesResultAndDirections = apiClient.getListSupportedLanguages(ui);
		Set<String> directions = supportedLanguagesResultAndDirections.getDirs();
		
		String[] sampleArr = {"az-ru", "be-bg", "be-cs", "be-de", "be-en", "be-es", "be-fr", "be-it", "be-pl", "be-ro", "be-ru", "be-sr", "be-tr", "bg-be", "bg-ru", "bg-uk", "ca-en", "ca-ru", "cs-be", "cs-en", "cs-ru", "cs-uk", "da-en", "da-ru", "de-be", "de-en", "de-es", "de-fr", "de-it", "de-ru", "de-tr", "de-uk", "el-en", "el-ru", "en-be", "en-ca", "en-cs", "en-da", "en-de", "en-el", "en-es", "en-et", "en-fi", "en-fr", "en-hu", "en-it", "en-lt", "en-lv", "en-mk", "en-nl", "en-no", "en-pt", "en-ru", "en-sk", "en-sl", "en-sq", "en-sv", "en-tr", "en-uk", "es-be", "es-de", "es-en", "es-ru", "es-uk", "et-en", "et-ru", "fi-en", "fi-ru", "fr-be", "fr-de", "fr-en", "fr-ru", "fr-uk", "hr-ru", "hu-en", "hu-ru", "hy-ru", "it-be", "it-de", "it-en", "it-ru", "it-uk", "lt-en", "lt-ru", "lv-en", "lv-ru", "mk-en", "mk-ru", "nl-en", "nl-ru", "no-en", "no-ru", "pl-be", "pl-ru", "pl-uk", "pt-en", "pt-ru", "ro-be", "ro-ru", "ro-uk", "ru-az", "ru-be", "ru-bg", "ru-ca", "ru-cs", "ru-da", "ru-de", "ru-el", "ru-en", "ru-es", "ru-et", "ru-fi", "ru-fr", "ru-hr", "ru-hu", "ru-hy", "ru-it", "ru-lt", "ru-lv", "ru-mk", "ru-nl", "ru-no", "ru-pl", "ru-pt", "ru-ro", "ru-sk", "ru-sl", "ru-sq", "ru-sr", "ru-sv", "ru-tr", "ru-uk", "sk-en", "sk-ru", "sl-en", "sl-ru", "sq-en", "sq-ru", "sr-be", "sr-ru", "sr-uk", "sv-en", "sv-ru", "tr-be", "tr-de", "tr-en", "tr-ru", "tr-uk", "uk-bg", "uk-cs", "uk-de", "uk-en", "uk-es", "uk-fr", "uk-it", "uk-pl", "uk-ro", "uk-ru", "uk-sr", "uk-tr"};
		final Set<String> sampleSet = new HashSet<>(Arrays.asList(sampleArr));
		assertTrue(directions.containsAll(sampleSet));
	}
	
	/**
	 * Проверка вывода списка поддерживаемых языков
	 * <br />
	 */
	@Test
	@DisplayName("Проверка вывода списка поддерживаемых языков")
	public void checkListSupportedLanguages() throws IOException
	{
		Gson gson = new Gson();
		Type stringStringMap = new TypeToken<Map<String, String>>()
		{
		}.getType();
		URL resource = Resources.getResource("getListSupportedLanguagesTest/sampleLanguages.json");
		String json = Resources.toString(resource, Charsets.UTF_8);
		Map<String, String> sample = gson.fromJson(json, stringStringMap);
		System.out.println(sample);
		
		final String ui = "ru";
		SupportedLanguagesResult supportedLanguagesResultAndDirections = apiClient.getListSupportedLanguages(ui);
		Map<String, String> languages = supportedLanguagesResultAndDirections.getLanguages();
		assertTrue(languages.equals(sample));
	}
}

import com.pampushko.translators.models.get_language_of_text.LanguageDetectingObj;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
@DisplayName("Проверка функции получения поддерживаемых языков и направлений перевода")
public class GetListSupportedLanguagesTest extends BaseTest
{
	/**
	 * Проверка вывода списка поддерживаемых языков
	 * <br />
	 */
	@Test
	@DisplayName("Проверка правильности определения языка по переданному образцу текста")
	public void checkListSupportedLanguages() throws IOException
	{
		String hint = "en,ru,de,tr"; //Список наиболее вероятных языков (им будет отдаваться предпочтение при определении языка текста). Разделитель списка — запятая.
		String text = "1978 yılında ekonomik reformların uygulanmasından beri Çin ekonomisi, Dünya'nın en hızlı " +
				"büyüyen ekonomilerinden biri olmuştur."; //турецкий язык
		LanguageDetectingObj language = apiClient.getLanguageOfText(text, hint);
		
		System.out.println("получили код языка из переданного образца текста (tr-турецкий)");
		System.out.println("----------------------------------------------");
		System.out.println(language.getLang());
		System.out.println();
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("Исходный текст:");
		System.out.println(text);
		assertEquals("tr", language.getLang());
	}
}

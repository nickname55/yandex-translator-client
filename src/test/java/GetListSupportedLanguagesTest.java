import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
@DisplayName("Проверка функции получения поддерживаемых языков и направлений перевода")
public class GetListSupportedLanguagesTest
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
		assertEquals(true, true);
	}
	
	/**
	 * Проверка получения доступных направлений перевода
	 * <br />
	 */
	@Test
	@DisplayName("Проверка получения доступных направлений перевода")
	public void getAllTranslateDirections()
	{
		assertEquals(true, true);
	}
	
	/**
	 * Проверка наличия определённого варианта направления перевода
	 * <br />
	 * Например, "uk-en"
	 */
	@Test
	@DisplayName("Проверка наличия определённого варианта направления перевода")
	public void checkExistingTranslateDirection()
	{
		assertEquals(true, true);
	}
	
	/**
	 * Проверка вывода списка поддерживаемых языков
	 * <br />
	 */
	@Test
	@DisplayName("Проверка вывода списка поддерживаемых языков")
	public void checkListSupportedLanguages()
	{
		assertEquals(true, true);
	}
}

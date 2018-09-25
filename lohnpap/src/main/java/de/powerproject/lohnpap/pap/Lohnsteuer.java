package de.powerproject.lohnpap.pap;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * 
 * @author Marcel Lehmann (https://github.com/MarcelLehmann/Lohnsteuer)
 * @date Tue Dec 05 21:08:50 CET 2017
 * 
 */

public class Lohnsteuer {

	public static Optional<? extends LohnsteuerInterface> getInstance(LocalDate date, LohnsteuerInput input) {

		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;

			return Arrays.stream(LohnsteuerPap.values())
					.filter(papMatch(year, month))
					.map(pap -> {
						try {
							final Constructor<? extends LohnsteuerInterface> constructor = pap.getPapClass().getConstructor(LohnsteuerInput.class);
							return constructor.newInstance(input);
						} catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
							throw new RuntimeException(e);
						}
					})
					.findFirst();
		}
		return Optional.empty();
	}

	private static Predicate<LohnsteuerPap> papMatch(int year, int month) {
		return pap -> pap.getYear() <= year && pap.getFromMonth() <= month && (pap.getToMonth() == null || pap.getToMonth() >= month);
	}
}
package com.chicken.bot.echo.utils;

import java.util.HashMap;
import java.util.Map;

public class KoreanUtils {
	private static Map<String, String> hasFinalSoundMap; // 이전 단어의 받침이 있는 경우
	private static Map<String, String> hasNotFinalSoundMap; // 이전 단어의 받침이 덦는 경우

	public KoreanUtils() {
		hasFinalSoundMap = new HashMap<String, String>();

		hasFinalSoundMap.put("를", "을");
		hasFinalSoundMap.put("가", "이");
		hasFinalSoundMap.put("야", "아");
		hasFinalSoundMap.put("와", "과");

		hasNotFinalSoundMap = new HashMap<String, String>();

		hasNotFinalSoundMap.put("을", "를");
		hasNotFinalSoundMap.put("이", "가");
		hasNotFinalSoundMap.put("아", "야");
		hasNotFinalSoundMap.put("과", "와");

		System.out.println("만들어짐여");
	}

	// TODO : static method
	public String correctSuffix(String text) {
		StringBuilder resultText = new StringBuilder();

		String[] words = text.split(" ");

		for (String word : words) {
			if (word.length() < 2) {
				resultText.append(word);
				resultText.append(" ");
				continue;

			}

			String suffix = word.substring(word.length() - 1);

			if (hasFinalSoundMap.containsKey(suffix) == false && hasNotFinalSoundMap.containsKey(suffix) == false) {
				resultText.append(word);
				resultText.append(" ");
				continue;

			}

			char lastChar = word.charAt(word.length() - 2);

			if ((lastChar - 0xAC00) % 28 > 0 && hasFinalSoundMap.containsKey(suffix)) {
				suffix = hasFinalSoundMap.get(suffix);

			} else if ((lastChar - 0xAC00) % 28 <= 0 && hasNotFinalSoundMap.containsKey(suffix)) {
				suffix = hasNotFinalSoundMap.get(suffix);

			}

			resultText.append(word.substring(0, word.length() - 1));
			resultText.append(suffix);
			resultText.append(" ");
		}

		return resultText.substring(0, resultText.length() - 1).toString();
	}

}

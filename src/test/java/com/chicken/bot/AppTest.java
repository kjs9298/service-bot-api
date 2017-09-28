package com.chicken.bot;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.chicken.bot.echo.utils.KoreanUtils;



/**
 * Unit test for simple App.
 */
public class AppTest {
    
   
	private String[][] replaceWords = {{"지수", "진솔"}, {"진솔", "지수"}};

    
    private String replaceWords(String text) {
		return StringUtils.replaceEach(text, replaceWords[0], replaceWords[1]);
		
	}

    @Test
    public void replaceText() {
    
    	KoreanUtils utils = new KoreanUtils();
    	
    	String replaceText = this.replaceWords("지수야 진솔아 치킨을 먹겠니?");
    	String resultText = utils.correctSuffix(replaceText);
    	
    	System.out.println(resultText);
    	
    }
    
    
}

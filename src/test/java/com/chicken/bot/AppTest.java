package com.chicken.bot;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;



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
    
    	String replaceText = this.replaceWords("지수야 진솔아 지수진솔아 지수함수야~");
    	System.out.println(replaceText);
    	
    }
    
    
}

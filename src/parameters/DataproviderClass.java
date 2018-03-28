package parameters;

import org.testng.annotations.DataProvider;
 
public class DataproviderClass {
 
        @DataProvider(name="SearchProvider")
 
        /*
         * DataProvider s/ reside in the same/base class where test method is  
         * put some other class, data provider method is static :
        */        
        public static Object[][] getDataFromDataprovider(){

            return new Object[][] {
 
                { "Genesis 1:1", "Genesis 1:1 KJV" },
 
                { "Psalm 19:1", "Psalm 19:1 KJV" },
 
                { "1 Corinthians 15:3-4", "1 Corinthians 15:3-4 KJV" },
                
                //False data 
                { "Hezekiah", "1 Hezekiah 1:1 KJV" },
                
                { "Mary", "Mary 1:1 KJV" }
                                              
                };       
        }}

package controller;

import java.util.Arrays;
import java.util.regex.*;
import model.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputIsValid {

    public static Date checkMonthDay(String md){
        String regex = "^(1[0-2]|[1-9]),(월|화|수|목|금|토|일)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(md);

        if (matcher.matches()) {
            int month = Integer.parseInt(matcher.group(1));
            String day = matcher.group(2);
            return new Date(month, day, 1);
        }
        return null;
    }

    public static List<String> checkNames(String names){
        String[] nameArray = names.split(",");
        List<String> nameList = new ArrayList<>(Arrays.asList(nameArray));

        Set<String> nameSet = new HashSet<>(nameList);
        if (nameSet.size() != nameList.size()) {
            return null;
        }

        for (String name : nameList) {
            if (name.length() > 5) {
                return null;
            }
        }
        if (nameList.size() < 5 || nameList.size() > 35) {
            return null;
        }

        return nameList;
    }

    public static String checkLength(List<String> normalNames, List<String> holidayNames){
        int nameSize = normalNames.size() + holidayNames.size();

        if (nameSize < 5 || nameSize > 35) {
            return null;
        }
        return "0";
    }

}

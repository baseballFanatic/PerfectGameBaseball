package Baseball;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringSupport {
    public StringSupport() {
        throw new UnsupportedOperationException("Creating instances of StringSupport Utility class is not supported!");
    }

    public static String safeTrim(String source) {
        return source == null ? null : source.trim();
    }

    public static String trim(String source, int length) {
        String trimmed = safeTrim(source);
        if (trimmed != null && trimmed.length() > length) {
            trimmed = trimmed.substring(0, length);
        }

        return trimmed;
    }

    public static String forceLength(String source, int length, char padCharacter) {
        return leftPad(trim(source, length), length, padCharacter);
    }

    public static boolean containsIgnoreCase(String source, String subString) {
        return source != null && subString != null && subString.length() > 0 && source.length() >= subString.length() && source.toUpperCase().contains(subString.toUpperCase());
    }

    public static int safeLength(String source) {
        int length = 0;
        if (null != source) {
            length = source.length();
        }

        return length;
    }

    public static boolean isEmptyString(String source) {
        return safeLength(safeTrim(source)) == 0;
    }

    public static boolean isEmptyTrimmedString(String source) {
        return isEmptyString(source);
    }

    public static boolean hasContents(String source) {
        boolean hasContents = false;
        if (source != null) {
            source = source.trim();
            hasContents = source.length() > 0 && !source.equalsIgnoreCase("null");
        }

        return hasContents;
    }

    public static boolean isDigitsOnly(String line) {
        return isDigits(line);
    }

    public static boolean isDigits(String source) {
        boolean digits = false;
        if (safeLength(source) > 0) {
            Pattern pattern = Pattern.compile("^\\d{1,}$");
            Matcher matcher = pattern.matcher(source);
            digits = matcher.find();
        }

        return digits;
    }

    public static String convertStackTraceToString(Throwable th) {
        ByteArrayOutputStream arrayStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(arrayStream);
        th.printStackTrace(printStream);
        String stackTrace = arrayStream.toString();
        printStream.close();
        return stackTrace;
    }

    public static int intFromString(String source) {
        Integer integer = integerFromString(source);
        return integer == null ? 0 : integer;
    }

    public static Integer integerFromString(String source) {
        source = safeTrim(source);
        Integer result = null;

        try {
            result = Integer.parseInt(source);
        } catch (Exception var3) {
            ;
        }

        return result;
    }

    public static boolean safeEqual(String a, String b) {
        boolean same;
        if (a == null) {
            same = b == null;
        } else if (b == null) {
            same = false;
        } else {
            same = a.equals(b);
        }

        return same;
    }

    public static boolean safeEqualIgnoreCase(String a, String b) {
        boolean same;
        if (a == null) {
            same = b == null;
        } else if (b == null) {
            same = false;
        } else {
            same = a.equalsIgnoreCase(b);
        }

        return same;
    }

    public static String removeChars(String source, String chars) {
        String result = "";
        if (safeLength(source) > 0) {
            if (safeLength(chars) > 0) {
                for(int i = 0; i < source.length(); ++i) {
                    char c = source.charAt(i);
                    if (chars.indexOf(c) < 0) {
                        result = result + c;
                    }
                }
            } else {
                result = source;
            }
        }

        return result;
    }

    public static BigDecimal bigDecimalFromString(String value) {
        return bigDecimalFromString(value, true);
    }

    public static BigDecimal bigDecimalFromString(String string, boolean forceZero) {
        BigDecimal bd = null;

        try {
            String value = string.trim();
            bd = new BigDecimal(removeChars(value, "$,% "));
        } catch (Exception var4) {
            if (forceZero) {
                bd = new BigDecimal(0.0D);
            }
        }

        return bd;
    }

    public static boolean booleanFromString(String value) {
        return value != null && (value.equals("1") || value.equalsIgnoreCase("true"));
    }

    public static String right(String source, int count) {
        if (null == source) {
            source = "";
        }

        int start = safeLength(source) - count;
        String result;
        if (count > 0 && start >= 0) {
            result = source.substring(start);
        } else {
            result = source;
        }

        return result;
    }

    public static String stringFromBoolean(boolean value) {
        return value ? "1" : "0";
    }

    public static String reduceToNumbers(String source) {
        String result = "";
        if (source != null) {
            for(int i = 0; i < source.length(); ++i) {
                char c = source.charAt(i);
                if (isDigit(c)) {
                    result = result + c;
                }
            }
        }

        return result;
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static String rightPad(String s, int length, char pad) {
        StringBuffer buffer;
        if (null != s) {
            buffer = new StringBuffer(s);

            while(buffer.length() < length) {
                buffer.append(pad);
            }
        } else {
            buffer = new StringBuffer("");
        }

        return buffer.toString();
    }

    public static String convertNonBreakingSpaceToSpace(String source) {
        StringBuilder result = new StringBuilder();
        if (!isEmptyString(source)) {
            for(int i = 0; i < source.length(); ++i) {
                int c = source.charAt(i);
                result.append(Character.toString((char)(c == 160 ? 32 : c)));
            }
        }

        return result.toString();
    }

    public static String removeLeading(String source, String characters) {
        if (null == source) {
            source = "";
        }

        if (null == characters) {
            characters = "";
        }

        while(source.length() > 0) {
            String firstCharacter = source.substring(0, 1);
            if (!characters.contains(firstCharacter)) {
                break;
            }

            if (source.length() > 1) {
                source = source.substring(1);
            } else {
                source = "";
            }
        }

        return source;
    }

    public static boolean isLowerAlpha(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean isUpperAlpha(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static boolean isAlpha(char c) {
        return isUpperAlpha(c) || isLowerAlpha(c);
    }

    public static boolean isAlphaNumeric(String source) {
        boolean alphaNumeric = false;
        if (!isEmptyString(source)) {
            alphaNumeric = true;

            for(int i = 0; i < source.length(); ++i) {
                char c = source.charAt(i);
                if (!isAlpha(c) && !isDigit(c)) {
                    alphaNumeric = false;
                    break;
                }
            }
        }

        return alphaNumeric;
    }

    public static boolean isStrictGuid(String value) {
        return value != null && value.length() == 32 && isAlphaNumeric(value);
    }

    public static String stringFromList(List<String> list, String delimiter) {
        return stringFromCollection(list, delimiter);
    }

    public static String stringFromList(List<String> list) {
        return stringFromCollection(list, ",");
    }

    public static String stringFromList(Set<String> set, String delimiter) {
        return stringFromCollection(set, delimiter);
    }

    public static String stringFromList(Set<String> set) {
        return stringFromCollection(set, ",");
    }

    public static int safeCollectionSize(Map map) {
        int count = 0;
        if (map != null) {
            count = map.size();
        }

        return count;
    }

    public static int safeCollectionSize(Collection collection) {
        int count = 0;
        if (collection != null) {
            count = collection.size();
        }

        return count;
    }

    public static boolean safeContainsIgnoreCase(String source, String target) {
        return source != null && target != null && target.length() > 0 && source.length() > 0 && source.toUpperCase().contains(target.toUpperCase());
    }

    public static List<String> listFromString(String source, String delimiter) {
        List<String> list = new ArrayList();
        if (source != null && delimiter != null && delimiter.length() > 0) {
            source = source.trim();
            if (source.length() > 0) {
                StringTokenizer stringTokenizer = new StringTokenizer(source, delimiter, false);

                while(stringTokenizer.hasMoreElements()) {
                    list.add(safeTrim((String)stringTokenizer.nextElement()));
                }
            }
        }

        return list;
    }

    public static List<String> listFromString(String source) {
        return listFromString(source, ",");
    }

    public static String replace(String source, String oldPattern, String newPattern) {
        if (oldPattern != null && !oldPattern.equals("")) {
            StringBuilder result = new StringBuilder();
            if (source != null && source.length() > 0) {
                int startIndex;
                int IndexOld;
                for(startIndex = 0; (IndexOld = source.indexOf(oldPattern, startIndex)) >= 0; startIndex = IndexOld + oldPattern.length()) {
                    result.append(source.substring(startIndex, IndexOld));
                    result.append(newPattern);
                }

                result.append(source.substring(startIndex));
            }

            return result.toString();
        } else {
            throw new IllegalArgumentException("Old pattern must have content.");
        }
    }

    public static String addLeading(String source, int length, char character) {
        while(source.length() < length) {
            source = character + source;
        }

        return source;
    }

    public static void addListToList(List<Object> destination, List<Object> source) {
        Iterator i$ = source.iterator();

        while(i$.hasNext()) {
            Object object = i$.next();
            destination.add(object);
        }

    }

    public static String addSpaceAfterComma(String source) {
        return replaceAll(replaceAll(source, ",", ".%$"), ".%$", ", ");
    }

    public static String addToCommaDelimitedString(String source, String addition) {
        StringBuffer out;
        if (isEmptyString(source)) {
            if (isEmptyString(addition)) {
                out = new StringBuffer();
            } else {
                out = new StringBuffer(addition);
            }
        } else {
            out = new StringBuffer(source);
            if (!isEmptyString(addition)) {
                out.append(",");
                out.append(addition);
            }
        }

        return out.toString();
    }

    public static String[] arrayFromList(List<String> source) {
        String[] results = null;
        if (source != null) {
            results = new String[source.size()];

            for(int i = 0; i < source.size(); ++i) {
                results[i] = (String)source.get(i);
            }
        }

        return results;
    }

    public static String capitalize(String value) {
        return value != null && value.length() > 0 ? value.substring(0, 1).toUpperCase() + value.substring(1) : value;
    }

    public static String changeSingleQuoteForHtml(String source) {
        return replaceAll(source, "'", "&#39;");
    }

    public static String changeSpacesToNonBreakingSpaces(String label) {
        char[] charArray = label.toCharArray();
        StringBuffer newLabel = new StringBuffer();
        char[] arr$ = charArray;
        int len$ = charArray.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            char singleChar = arr$[i$];
            if (Character.isWhitespace(singleChar)) {
                newLabel.append("&nbsp;");
            } else {
                newLabel.append(singleChar);
            }
        }

        return newLabel.toString();
    }

    public static List<String> chop(String source, int minChars, char delimiter, int rows, String emptyText) {
        if (source != null && minChars >= 1 && rows >= 1) {
            List<String> items = new ArrayList();
            source = safeTrim(source);
            int length = source.length();
            if (length == 0) {
                items.add("");
            } else {
                label52:
                while(true) {
                    while(true) {
                        if (length <= 0) {
                            break label52;
                        }

                        if (length <= minChars && !source.contains(getStringFromChar(delimiter))) {
                            items.add(safeTrim(source));
                            length = 0;
                        } else {
                            int position;
                            for(position = 0; position < length && position < minChars && source.charAt(position) != delimiter; ++position) {
                                ;
                            }

                            if (position == length) {
                                items.add(rightPad(source, minChars, ' '));
                                length = 0;
                            } else {
                                items.add(rightPad(source.substring(0, position + 1), minChars, ' '));
                                source = source.substring(position + 1);
                                length = source.length();
                            }
                        }
                    }
                }
            }

            while(items.size() < rows) {
                items.add(emptyText);
            }

            return items;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static String convertSelectOneAndNullToEmptyString(String source) {
        if (source == null || source.equals("Select One")) {
            source = "";
        }

        return source;
    }

    public static String convertToEmptyIfNull(String source) {
        String result = source;
        if (source == null) {
            result = "";
        }

        return result;
    }

    public static String convertToNullIfEmpty(String source) {
        String result = source;
        if (source != null) {
            result = source.trim();
            if (result.length() == 0) {
                result = null;
            }
        }

        return result;
    }

    public static String convertToHex(String source) {
        String hex = "";

        for(int i = 0; i < safeLength(source); ++i) {
            hex = hex + Integer.toHexString(source.charAt(i));
        }

        return hex;
    }

    public static String decorateCharacter(char c) {
        return "[!%" + c + "%!]";
    }

    public static double doubleFromString(String source) {
        source = safeTrim(source);
        double result = 0.0D;

        try {
            result = Double.parseDouble(source);
        } catch (Exception var4) {
            ;
        }

        return result;
    }

    public static String escapeJSQuote(String source) {
        String result = "";
        if (source != null) {
            result = replace(source, "'", "\\'");
        }

        return result;
    }

    public static String firstInList(String source) {
        String result = null;
        List<String> list = listFromString(source);
        if (list != null && list.size() > 0) {
            result = (String)list.get(0);
        }

        return result;
    }

    public static String getDisplayField(BigDecimal value) {
        return getDisplayField(value.toString());
    }

    public static String getDisplayField(String value) {
        String result = value;
        if (!isEmptyString(value)) {
            result = "$" + value;
        }

        return result;
    }

    public static String getJsField(String name, String value) {
        StringBuilder jsObjectMember = new StringBuilder();
        jsObjectMember.append("'");
        jsObjectMember.append(name);
        jsObjectMember.append("' : ");
        jsObjectMember.append("'");
        jsObjectMember.append(value);
        jsObjectMember.append("' ");
        return jsObjectMember.toString();
    }

    public static Set<String> getMapValues(List<Map<String, String>> rows, String key) {
        Set<String> currentIds = new LinkedHashSet();
        Iterator i$ = rows.iterator();

        while(i$.hasNext()) {
            Map<String, String> row = (Map)i$.next();
            currentIds.add(row.get(key));
        }

        return currentIds;
    }

    public static String getStringFromChar(int character) {
        char[] charArray = new char[]{(char)character};
        return new String(charArray);
    }

    public static String inDoubleQuotes(String source) {
        return "\"" + source + "\"";
    }

    public static boolean inList(char c, byte[] validChars) {
        boolean found = false;
        if (validChars != null && validChars.length > 0) {
            byte[] arr$ = validChars;
            int len$ = validChars.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                byte b = arr$[i$];
                if (c == b) {
                    found = true;
                    break;
                }
            }
        }

        return found;
    }

    public static boolean inStringArray(String source, String[] targets) {
        boolean found = false;
        if (safeLength(source) > 0 && targets != null && targets.length > 0) {
            String[] arr$ = targets;
            int len$ = targets.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String target = arr$[i$];
                if (safeEqual(source, target)) {
                    found = true;
                    break;
                }
            }
        }

        return found;
    }

    public static String invert(String value) {
        return stringFromBoolean(!booleanFromString(value));
    }

    public static String invertBooleanString(String value) {
        return value.equals("1") ? "0" : "1";
    }

    public static boolean isAlpha(String source) {
        boolean alpha = false;
        if (!isEmptyString(source)) {
            alpha = true;

            for(int i = 0; i < source.length(); ++i) {
                char c = source.charAt(i);
                if (!isAlpha(c)) {
                    alpha = false;
                    break;
                }
            }
        }

        return alpha;
    }

    public static boolean isAlphaNumericPlus(String source, String validCharacters) {
        boolean valid = false;
        byte[] list = validCharacters.getBytes();
        if (!isEmptyString(source)) {
            valid = true;

            for(int i = 0; i < source.length(); ++i) {
                char c = source.charAt(i);
                if (!isAlpha(c) && !isDigit(c) && !inList(c, list)) {
                    valid = false;
                    break;
                }
            }
        }

        return valid;
    }

    public static boolean isAlphaNumericSpace(String source) {
        boolean valid = false;
        if (!isEmptyString(source)) {
            valid = true;

            for(int i = 0; i < source.length(); ++i) {
                char c = source.charAt(i);
                if (!isAlpha(c) && !isDigit(c) && c != ' ') {
                    valid = false;
                    break;
                }
            }
        }

        return valid;
    }

    public static boolean isBadCharacter(char key, boolean allowQuestionable) {
        boolean bad;
        if (!isAlpha(key) && !isDigit(key)) {
            switch(key) {
                case ' ':
                case '!':
                case '%':
                case '+':
                case '-':
                case '.':
                case '@':
                case '^':
                case '_':
                case '~':
                    bad = false;
                    break;
                case '"':
                case '$':
                case '\'':
                case ',':
                case ':':
                case ';':
                case '<':
                case '>':
                case '?':
                case '[':
                case '\\':
                case ']':
                case '`':
                case '{':
                case '|':
                case '}':
                    bad = true;
                    break;
                case '#':
                case '&':
                case '(':
                case ')':
                case '*':
                case '/':
                    bad = !allowQuestionable;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '=':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                default:
                    bad = true;
            }
        } else {
            bad = false;
        }

        return bad;
    }

    public static boolean isBadString(String source, boolean allowQuestionable) {
        boolean valid = false;
        if (!isEmptyString(source)) {
            valid = true;

            for(int i = 0; i < source.length(); ++i) {
                char c = source.charAt(i);
                if (isBadCharacter(c, allowQuestionable)) {
                    valid = false;
                    break;
                }
            }
        }

        return valid;
    }

    public static boolean isCharacterADigit(String source, int position) {
        boolean result = false;
        if (!safeEmpty(source) && Character.isDigit(source.charAt(position))) {
            result = true;
        }

        return result;
    }

    public static boolean isDigitsPlus(String source, String validCharacters) {
        boolean valid = false;
        byte[] list = validCharacters.getBytes();
        if (!isEmptyString(source)) {
            valid = true;

            for(int i = 0; i < source.length(); ++i) {
                char c = source.charAt(i);
                if (!isDigit(c) && !inList(c, list)) {
                    valid = false;
                    break;
                }
            }
        }

        return valid;
    }

    public static boolean isEmptyArray(String[] values) {
        boolean empty = true;
        String[] arr$ = values;
        int len$ = values.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            String value = arr$[i$];
            if (value != null && value.length() > 0) {
                empty = false;
                break;
            }
        }

        return empty;
    }

    public static boolean isKeyInListOfMaps(String keyValue, String keyName, List<Map<String, String>> listOfMaps) {
        boolean foundInList = false;
        if (!isEmptyString(keyValue) && !isEmptyString(keyName)) {
            if (safeCollectionSize((Collection)listOfMaps) > 0) {
                Iterator i$ = listOfMaps.iterator();

                while(i$.hasNext()) {
                    Map<String, String> map = (Map)i$.next();
                    if (safeEqual(keyValue, (String)map.get(keyName))) {
                        foundInList = true;
                        break;
                    }
                }
            }

            return foundInList;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isNumericPlus(String source, String validCharacters) {
        boolean valid = false;
        byte[] list = validCharacters.getBytes();
        if (!isEmptyString(source)) {
            valid = true;

            for(int i = 0; i < source.length(); ++i) {
                char c = source.charAt(i);
                if (!isDigit(c) && !inList(c, list)) {
                    valid = false;
                    break;
                }
            }
        }

        return valid;
    }

    public static boolean isSelectOptionSelected(String value) {
        return !isEmptyString(value) && !safeEqual(value, "Select One") && !safeEqual(value, "None") && !safeEqual(value, "none");
    }

    public static boolean isSubset(List<String> subset, List<String> superSet) {
        boolean result = true;
        Iterator i$ = subset.iterator();

        while(i$.hasNext()) {
            String value = (String)i$.next();
            result = superSet.contains(value);
            if (!result) {
                break;
            }
        }

        return result;
    }

    public static boolean isWindowsMode() {
        return File.separatorChar == '\\';
    }

    public static String leadCapEachWord(String source) {
        List<String> list = listFromString(source, " ");
        List<String> newList = new ArrayList();
        Iterator i$ = list.iterator();

        while(i$.hasNext()) {
            String word = (String)i$.next();
            newList.add(makeLeadingCap(word));
        }

        return stringFromList((List)newList, " ");
    }

    public static String leftPad(String s, int length, char pad) {
        StringBuffer buffer = new StringBuffer(s);

        while(buffer.length() < length) {
            buffer.insert(0, pad);
        }

        return buffer.toString();
    }

    public static List<String> listFromMaps(List<Map<String, String>> maps, String key) {
        List<String> results = new ArrayList();
        if (maps != null && maps.size() > 0) {
            Iterator i$ = maps.iterator();

            while(i$.hasNext()) {
                Map<String, String> map = (Map)i$.next();
                String value = (String)map.get(key);
                if (!isEmptyString(value)) {
                    results.add(value);
                }
            }
        }

        return results;
    }

    public static String lowerCaseFirstLetter(String source) {
        String returnValue = "";
        if (source != null) {
            if (source.length() > 1) {
                returnValue = source.substring(0, 1).toLowerCase() + source.substring(1);
            } else {
                returnValue = source.toLowerCase();
            }
        }

        return returnValue;
    }

    public static String makeLeadingCap(String source) {
        String result = null;
        if (source != null && source.length() > 0) {
            if (source.length() > 1) {
                result = source.substring(0, 1).toUpperCase() + source.substring(1).toLowerCase();
            } else {
                result = source.toUpperCase();
            }
        }

        return result;
    }

    public static boolean mapContains(List<Map<String, String>> maps, String columnName, String value) {
        boolean found = false;
        if (maps != null && maps.size() > 0) {
            Iterator i$ = maps.iterator();

            while(i$.hasNext()) {
                Map<String, String> map = (Map)i$.next();
                if (safeEqual((String)map.get(columnName), value)) {
                    found = true;
                    break;
                }
            }
        }

        return found;
    }

    public static String reduceToLetters(String source) {
        String result = "";
        if (source != null) {
            for(int i = 0; i < source.length(); ++i) {
                char c = source.charAt(i);
                if (isAlpha(c)) {
                    result = result + c;
                }
            }
        }

        return result;
    }

    public static String reduceToLettersNumbers(String source) {
        String result = "";
        if (source != null) {
            for(int i = 0; i < source.length(); ++i) {
                char c = source.charAt(i);
                if (isAlpha(c) || isDigit(c)) {
                    result = result + c;
                }
            }
        }

        return result;
    }

    public static String reduceToNumbers(String source, char wildcard) {
        String result = "";
        if (source != null) {
            for(int i = 0; i < source.length(); ++i) {
                char c = source.charAt(i);
                if (isDigit(c) || c == wildcard) {
                    result = result + c;
                }
            }
        }

        return result;
    }

    public static String reduceToNumbersDecimal(String source) {
        String result = "";
        if (source != null) {
            for(int i = 0; i < source.length(); ++i) {
                char c = source.charAt(i);
                if (isDigit(c) || c == '.') {
                    result = result + c;
                }
            }
        }

        return result;
    }

    public static String removeChar(String source, char c) {
        String result = "";
        if (source != null) {
            for(int i = 0; i < source.length(); ++i) {
                if (source.charAt(i) != c) {
                    result = result + source.charAt(i);
                }
            }
        }

        return result;
    }

    public static String removeCharAt(String source, int position) {
        return source.substring(0, position) + source.substring(position + 1);
    }

    public static String removeCommaFromAmount(String source) {
        String result = "";
        if (source != null) {
            result = source.replaceAll(",", "");
        }

        return result;
    }

    public static List<String> removeDuplicates(List<String> source) {
        Set<String> set = new HashSet();
        List<String> newList = new ArrayList();
        Iterator i$ = source.iterator();

        while(i$.hasNext()) {
            String element = (String)i$.next();
            if (set.add(element)) {
                newList.add(element);
            }
        }

        return newList;
    }

    public static String removeExtraSpaces(String input) {
        if (input == null) {
            return null;
        } else {
            input = input.trim();
            if (input.length() == 0) {
                return input;
            } else {
                char[] charArray = input.toCharArray();
                StringBuffer newString = new StringBuffer();
                boolean lastCharacterWasWhitespace = false;
                char[] arr$ = charArray;
                int len$ = charArray.length;

                for(int i$ = 0; i$ < len$; ++i$) {
                    char singleChar = arr$[i$];
                    if (Character.isWhitespace(singleChar)) {
                        if (!lastCharacterWasWhitespace) {
                            newString.append(singleChar);
                        }

                        lastCharacterWasWhitespace = true;
                    } else {
                        newString.append(singleChar);
                        lastCharacterWasWhitespace = false;
                    }
                }

                return newString.toString();
            }
        }
    }

    public static String removeHtml(String source) {
        source = safeTrim(source);
        StringBuffer result = new StringBuffer();
        Pattern pattern = Pattern.compile("([^<]*)<[^>]*>(.*)");

        while(safeLength(source) > 0) {
            Matcher matcher = pattern.matcher(source);
            if (matcher.find()) {
                String beforeHtml = matcher.group(1);
                String afterHtml = matcher.group(2);
                result.append(beforeHtml);
                source = afterHtml;
            } else {
                result.append(source);
                source = null;
            }
        }

        return result.toString();
    }

    public static String removeSuffix(String source, String suffix) {
        String result = source;
        if (source != null && suffix != null && source.length() > 0 && suffix.length() > 0 && source.endsWith(suffix)) {
            if (source.equals(suffix)) {
                result = "";
            } else {
                result = source.substring(0, source.length() - suffix.length());
            }
        }

        return result;
    }

    public static String removeTrailingString(String source, String characters) {
        String result = source;
        if (source != null && source.endsWith(characters)) {
            if (source.equals(characters)) {
                result = "";
            } else {
                result = source.substring(0, source.length() - characters.length());
            }
        }

        return result;
    }

    public static String repeatString(String value, int count) {
        return repeatString(value, count, ",");
    }

    public static String repeatString(String value, int count, String delimiter) {
        String result = "";

        for(int i = 0; i < count; ++i) {
            if (i > 0) {
                result = result + delimiter;
            }

            result = result + value;
        }

        return result;
    }

    public static String replaceAll(String source, String oldPattern, String newPattern) {
        while(source != null && source.length() > 0 && source.indexOf(oldPattern) >= 0) {
            source = replace(source, oldPattern, newPattern);
        }

        return source;
    }

    public static String safe(String source) {
        return convertToEmptyIfNull(source);
    }

    public static String safe(byte[] bytes) {
        String result;
        if (bytes != null) {
            result = new String(bytes);
        } else {
            result = "";
        }

        return result;
    }

    public static String safeUpperCase(String source) {
        if (source != null) {
            source = source.toUpperCase();
        } else {
            source = "";
        }

        return source;
    }

    public static boolean sameBigDecimalString(String one, String two) {
        BigDecimal first = bigDecimalFromString(removeLeading(safeTrim(one), "$"), true);
        BigDecimal second = bigDecimalFromString(removeLeading(safeTrim(two), "$"), true);
        return first.compareTo(second) == 0;
    }

    public static boolean sameMap(Map<String, String> first, Map<String, String> second) {
        boolean same = true;
        if (first == null && second == null) {
            same = true;
        } else if ((first == null || second != null) && first != null) {
            if (first.size() != second.size()) {
                same = false;
            } else {
                Set<String> firstSet = first.keySet();
                Iterator i$ = firstSet.iterator();

                while(i$.hasNext()) {
                    String key = (String)i$.next();
                    if (!safeEqual((String)first.get(key), (String)second.get(key))) {
                        same = false;
                        break;
                    }
                }
            }
        } else {
            same = false;
        }

        return same;
    }

    public static String stringFromArray(String[] list) {
        return stringFromCollection(Arrays.asList(list), ",");
    }

    public static String stringFromArray(String[] list, String delimiter) {
        return stringFromCollection(Arrays.asList(list), delimiter);
    }

    public static String stringFromCollection(Collection<String> collection, String delimiter) {
        StringBuffer result = new StringBuffer();
        if (collection != null && collection.size() > 0) {
            Iterator i$ = collection.iterator();

            while(i$.hasNext()) {
                String value = (String)i$.next();
                if (result.length() > 0) {
                    result.append(delimiter);
                }

                if (value != null) {
                    result.append(value);
                }
            }
        }

        return result.toString();
    }

    public static String stringFromMap(Map<String, String> source) {
        return stringFromMap(source, ",");
    }

    public static String stringFromMap(Map<String, String> source, String delimiter) {
        String result = null;
        if (source != null && source.size() > 0) {
            StringBuffer values = new StringBuffer();

            Entry pairs;
            for(Iterator i$ = source.entrySet().iterator(); i$.hasNext(); values.append((String)pairs.getKey())) {
                pairs = (Entry)i$.next();
                if (values.length() > 0) {
                    values.append(delimiter);
                }
            }

            result = values.toString();
        }

        return result;
    }

    public static String stripControlCharacters(String rawString) {
        String value = null;
        if (rawString != null) {
            value = rawString.replaceAll("\\p{Cntrl}", "");
        }

        return value;
    }

    public static String translateAll(String source, char target) {
        char[] data = new char[]{target};
        String oldPattern = new String(data);
        String newPattern = decorateCharacter(target);
        return replaceAll(source, oldPattern, newPattern);
    }

    public static String translatedStringFromList(List<String> list) {
        String delimiter = ",";
        StringBuffer result = new StringBuffer();
        if (list != null && list.size() > 0) {
            Iterator i$ = list.iterator();

            while(i$.hasNext()) {
                String value = (String)i$.next();
                if (value != null) {
                    if (result.length() > 0) {
                        result.append(",");
                    }

                    result.append(translateAll(value, ','));
                }
            }
        }

        return result.toString();
    }

    public static List<String> trimAllInList(List<String> values) {
        List<String> results = null;
        if (values != null) {
            results = new ArrayList();
            Iterator i$ = values.iterator();

            while(i$.hasNext()) {
                String value = (String)i$.next();
                results.add(safeTrim(value));
            }
        }

        return results;
    }

    public static String untranslateAll(String source, char target) {
        char[] data = new char[]{target};
        String oldPattern = decorateCharacter(target);
        String newPattern = new String(data);
        return replaceAll(source, oldPattern, newPattern);
    }

    public static List<String> untranslatedListFromString(String source) {
        String delimiter = ",";
        List<String> List = new ArrayList();
        if (source != null && source.length() > 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(source, ",", false);

            while(stringTokenizer.hasMoreElements()) {
                List.add(untranslateAll((String)stringTokenizer.nextElement(), ','));
            }
        }

        return List;
    }

    public static String upperCaseFirstLetter(String source) {
        String returnValue = "";
        if (source != null) {
            if (source.length() > 1) {
                returnValue = source.substring(0, 1).toUpperCase() + source.substring(1);
            } else {
                returnValue = source.toUpperCase();
            }
        }

        return returnValue;
    }

    public static boolean safeStartsWith(String source, String searchString) {
        boolean result = false;
        if (source != null && searchString != null && searchString.length() > 0 && source.length() > 0) {
            result = source.toUpperCase().startsWith(searchString.toUpperCase());
        }

        return result;
    }

    public static boolean safeHasContents(String source) {
        return hasContents(source);
    }

    public static boolean safeEmpty(String source) {
        return safeLength(source) <= 0;
    }

    public static boolean safeContains(String source, String target) {
        return source != null && target != null && target.length() > 0 && source.length() > 0 && source.contains(target);
    }

    public static boolean safeEqualTreatNullAsEmptyString(String a, String b) {
        if (a == null) {
            a = "";
        }

        if (b == null) {
            b = "";
        }

        return safeEqual(a, b);
    }

    public static String safeStateId(String stateId) {
        return stateId != null && stateId.length() < 3 ? stateId : null;
    }

    public static String safeToUpper(String value) {
        String result = value;
        if (value != null) {
            result = value.toUpperCase();
        }

        return result;
    }

    public static boolean safeEqual(String a, int b) {
        return safeEqual(a, b + "");
    }

    public static boolean safeEqual(int a, String b) {
        return safeEqual(a + "", b);
    }

    public static BigDecimal safeBigDecimalFromString(String amount) {
        return isEmptyTrimmedString(amount) ? BigDecimal.ZERO : bigDecimalFromString(amount);
    }

    public static String safeToString(Object object) {
        return object == null ? null : object.toString();
    }

    public static <T> boolean equal(T a, T b) {
        boolean equal;
        if (a == null) {
            equal = b == null;
        } else if (b == null) {
            equal = false;
        } else {
            equal = a.equals(b);
        }

        return equal;
    }

    public static String removeWhitespace(String line) {
        StringBuffer result = new StringBuffer();
        if (line != null) {
            char[] arr$ = line.toCharArray();
            int len$ = arr$.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                char character = arr$[i$];
                if (!Character.isWhitespace(character)) {
                    result.append(character);
                }
            }
        }

        return result.toString();
    }
}
import java.io.*;
import java.util.Arrays;

public class ReadArrayFromFileImpl implements ReadArrayFromFile {

    /*
    Метод конвертации строковой квадратной матрицы в целочисленную квадратную матрицц
    */
    @Override
    public int[] getIntArrayFromFile(String fileName) {
        String stringArray = getStringArrayFromFile(fileName);
        System.out.println("************ Read From File:");
        System.out.println(stringArray);

        int[] intArray = convertArrayFromStringToInt(stringArray);
        System.out.println("************ After Convert From String To Int:");
        System.out.println(Arrays.toString(intArray));

        return intArray;
    }

    private String getStringArrayFromFile(String fileName) {
        String result = "";

        try {
            FileReader reader = new FileReader(new File(fileName));
            try {
                if (reader.ready()) {
                    BufferedReader br = new BufferedReader(reader);

                    result = br.readLine().trim();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    private int[] convertArrayFromStringToInt(String str) {
        int[] result = new int[0];

        int length = getLength(str);
        if (length != 0) {
            result = convertStringArrayToIntArray(str, length);
        }
        return result;
    }

    private int[] convertStringArrayToIntArray(String str, int length) {
        int[] result = new int[length];

        String[] strArray = getStringArray(str);
        for (int i = 0; i < strArray.length; i++) {
            result[i] = Integer.valueOf(strArray[i].trim());
        }

        return result;
    }

    private String[] getStringArray(String str) {
        return str.trim().split(",");
    }

    private int getLength(String str) {
        return str.length() - str.replace(",", "").length();
    }
}

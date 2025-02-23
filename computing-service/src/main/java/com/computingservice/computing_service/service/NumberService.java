package com.computingservice.computing_service.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NumberService {

    public long processNumber(long number) {
        String transformed = shiftDigits(String.valueOf(number));
        System.out.println("After shift: " + transformed);
        transformed = multiplyDigits(transformed);
        System.out.println("After shift: " + transformed);
        transformed = removeSevens(transformed);
        System.out.println("After shift: " + transformed);
        return divideByEvenCount(transformed);
    }

    public String shiftDigits(String number) {
        char[] digits = number.toCharArray();
        List<Integer> positions = new ArrayList<>();

        // 1. Najdeme pozice všech číslic ≤ 3
        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] <= '3') {
                positions.add(i);
            }
        }

        // 2. Posouváme číslice doprava OD KONCE (abychom si nepřepsali předchozí posuny)
        for (int i = positions.size() - 1; i >= 0; i--) {
            int pos = positions.get(i);
            // Zkontrolujeme, že nepřekročíme hranici pole
            if (pos < digits.length - 1) {
                char temp = digits[pos];
                digits[pos] = digits[pos + 1];
                digits[pos + 1] = temp;
            }
        }

        return new String(digits);
    }



    // 2. Násobení číslic 8 a 9 dvakrát
    public String multiplyDigits(String number) {
        StringBuilder result = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (c == '8' || c == '9') {
                result.append(Character.getNumericValue(c) * 2);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // 3. Odstranění všech číslic 7
    public String removeSevens(String number) {
        return number.replace("7", "");
    }

    // 4. Vydělení počtem sudých číslic
    public long divideByEvenCount(String number) {
        long result = Long.parseLong(number);
        long evenCount = number.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> (c - '0') % 2 == 0)
                .count();

        return evenCount > 0 ? result / evenCount : result;
    }
}



package by.epam.wordsnumbers.controller;

import by.epam.wordsnumbers.exception.WrongNumberException;
import by.epam.wordsnumbers.scanner.ReadNumbers;

public class NumbersInWordsCommand {
    public void exec() {
        ReadNumbers readNumbers = new ReadNumbers();
        int number = readNumbers.read();
        print(number, returnNumbersInWords(number));
    }

    public String returnNumbersInWords(int number) {
        String numberInWord;
        if (number == 0) {
            numberInWord = getFemaleDigit1(number);
        } else if (number > 999 && number < 10000) {
            numberInWord = getDigit1000(number);
        } else if (number > 99 && number < 1000) {
            numberInWord = getDigit100(number);
        } else if (number > 19 && number < 100) {
            numberInWord = getDigit20(number);
        } else if (number > 9 && number < 20) {
            numberInWord = getDigit10(number);
        } else {
            numberInWord = getMaleDigit1(number);
        }
        return numberInWord
                + addRuble(number);
    }

    public String addRuble(int number) {
        if (number > 99 && number < 10000) {
            if (number % 100 > 19) {
                return " " + getRuble(number % 10);
            } else {
                return " " + getRuble(number % 100);
            }
        } else if (number > 19 && number < 100) {
            return " " + getRuble(number % 10);
        } else {
            return " " + getRuble(number);
        }
    }

    public String getRuble(int number) {
        String numberInWord;
        switch (number) {
            case 0:
                numberInWord = "рублей";
                break;
            case 1:
                numberInWord = "рубль";
                break;
            case 2:
            case 3:
            case 4:
                numberInWord = "рубля";
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                numberInWord = "рублей";
                break;
            default:
                throw new WrongNumberException("Wrong data");
        }
        return numberInWord;
    }

    public String getDigit1000(int number) {
        String numberInWord;
        switch (number / 1000) {
            case 1:
                numberInWord = "тысяча";
                break;
            case 2:
            case 3:
            case 4:
                numberInWord = "тысячи";
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                numberInWord = "тысяч";
                break;
            default:
                throw new WrongNumberException("Wrong data");
        }
        if (number % 1000 != 0) {
            if (number % 1000 >= 100) {
                return getFemaleDigit1(number / 1000) + " " + numberInWord + " " + getDigit100(number % 1000);
            } else if (number % 1000 > 19 && number % 1000 < 100) {
                return getFemaleDigit1(number / 1000) + " " + numberInWord + " " + getDigit20(number % 100);
            } else if (number % 1000 < 10) {
                return getFemaleDigit1(number / 1000) + " " + numberInWord + " " + getMaleDigit1(number % 10);
            } else {
                return getFemaleDigit1(number / 1000) + " " + numberInWord + " " + getDigit10(number % 100);
            }
        }
        return getFemaleDigit1(number / 1000) + " " + numberInWord;
    }

    public String getMaleDigit1(int number) {
        String numberInWord;
        switch (number) {
            case 0:
                numberInWord = "";
                break;
            case 1:
                numberInWord = "один";
                break;
            case 2:
                numberInWord = "два";
                break;
            case 3:
                numberInWord = "три";
                break;
            case 4:
                numberInWord = "четыре";
                break;
            case 5:
                numberInWord = "пять";
                break;
            case 6:
                numberInWord = "шесть";
                break;
            case 7:
                numberInWord = "семь";
                break;
            case 8:
                numberInWord = "восемь";
                break;
            case 9:
                numberInWord = "девять";
                break;
            default:
                throw new WrongNumberException("Wrong data");
        }
        return numberInWord;
    }

    public String getFemaleDigit1(int number) {
        String numberInWord;
        switch (number) {
            case 0:
                numberInWord = "ноль";
                break;
            case 1:
                numberInWord = "одна";
                break;
            case 2:
                numberInWord = "две";
                break;
            case 3:
                numberInWord = "три";
                break;
            case 4:
                numberInWord = "четыре";
                break;
            case 5:
                numberInWord = "пять";
                break;
            case 6:
                numberInWord = "шесть";
                break;
            case 7:
                numberInWord = "семь";
                break;
            case 8:
                numberInWord = "восемь";
                break;
            case 9:
                numberInWord = "девять";
                break;
            default:
                throw new WrongNumberException("Wrong data");
        }
        return numberInWord;
    }

    public String getDigit10(int number) {
        String numberInWord;
        switch (number) {
            case 10:
                numberInWord = "десять";
                break;
            case 11:
                numberInWord = "одиннадцать";
                break;
            case 12:
                numberInWord = "двенадцать";
                break;
            case 13:
                numberInWord = "тринадцать";
                break;
            case 14:
                numberInWord = "четырнадцать";
                break;
            case 15:
                numberInWord = "пятнадцать";
                break;
            case 16:
                numberInWord = "шестнадцать";
                break;
            case 17:
                numberInWord = "семнадцать";
                break;
            case 18:
                numberInWord = "восемнадцать";
                break;
            case 19:
                numberInWord = "девятнадцать";
                break;
            default:
                throw new WrongNumberException("Wrong data");
        }
        return numberInWord;
    }

    public String getDigit20(int number) {
        String numberInWord;
        switch (number / 10) {
            case 0:
            case 1:
                numberInWord = "";
                break;
            case 2:
                numberInWord = "двадцать";
                break;
            case 3:
                numberInWord = "тридцать";
                break;
            case 4:
                numberInWord = "сорок";
                break;
            case 5:
                numberInWord = "пятьдесят";
                break;
            case 6:
                numberInWord = "шестьдесят";
                break;
            case 7:
                numberInWord = "семьдесят";
                break;
            case 8:
                numberInWord = "восемьдесят";
                break;
            case 9:
                numberInWord = "девяносто";
                break;
            default:
                throw new WrongNumberException("Wrong data");
        }
        if (number % 10 != 0) {
            if (number > 19) {
                return numberInWord + " " + getMaleDigit1(number % 10);
            } else if (number < 10) {
                return numberInWord + getMaleDigit1(number);
            } else {
                return numberInWord + getDigit10(number); //
            }
        } else if (number == 10) {
            return getDigit10(10);
        }
        return numberInWord;
    }

    public String getDigit100(int number) {
        String numberInWord;
        switch (number / 100) {
            case 1:
                numberInWord = "сто";
                break;
            case 2:
                numberInWord = "двести";
                break;
            case 3:
                numberInWord = "триста";
                break;
            case 4:
                numberInWord = "четыреста";
                break;
            case 5:
                numberInWord = "пятьсот";
                break;
            case 6:
                numberInWord = "шестьсот";
                break;
            case 7:
                numberInWord = "семьсот";
                break;
            case 8:
                numberInWord = "восемьсот";
                break;
            case 9:
                numberInWord = "девятьсот";
                break;
            default:
                throw new WrongNumberException("Wrong data");
        }
        if (number % 100 != 0) {
            return numberInWord + " " + getDigit20(number % 100);
        }
        return numberInWord;
    }

    public void print(int number, String numberInWords) {
        System.out.println("Number is " + number + " (" + numberInWords + ").");
    }


}

package com.itproger;

import java.util.*;

public class Zodiac12 {

    // Klasa do reprezentacji znaku zodiaku
    static class ZodiacSign {
        String name;
        int startDay;
        int startMonth;
        int endDay;
        int endMonth;
        String description;

        public ZodiacSign(String name, int startDay, int startMonth, int endDay, int endMonth, String description) {
            this.name = name;
            this.startDay = startDay;
            this.startMonth = startMonth;
            this.endDay = endDay;
            this.endMonth = endMonth;
            this.description = description;
        }

        public boolean isDateWithinRange(int day, int month) {
            if (startMonth == endMonth) {
                return month == startMonth && day >= startDay && day <= endDay;
            } else {
                return (month == startMonth && day >= startDay) || (month == endMonth && day <= endDay);
            }
        }

        @Override
        public String toString() {
            return name + " (" + String.format("%02d.%02d", startDay, startMonth) + " - " +
                    String.format("%02d.%02d", endDay, endMonth) + "): " + description;
        }
    }

    // Metoda do generowania horoskopu na podstawie losowych przewidywań
    public static String generateHoroscope(String sign) {
        Map<String, List<String>> dailyHoroscopes = new HashMap<>();

        dailyHoroscopes.put("aries", Arrays.asList(
                "Bold moves bring success today.",
                "Trust your instincts.",
                "A surprise awaits you in your career."));
        dailyHoroscopes.put("taurus", Arrays.asList(
                "Practical decisions will yield great rewards.",
                "Patience is your strength today.",
                "A loved one will seek your advice."));
        dailyHoroscopes.put("gemini", Arrays.asList(
                "Communication will open new doors.",
                "Share your ideas confidently.",
                "Adaptability is key to your success today."));
        dailyHoroscopes.put("cancer", Arrays.asList(
                "Emotional balance will guide you.",
                "A close friend will bring good news.",
                "Stay calm during challenges."));
        dailyHoroscopes.put("leo", Arrays.asList(
                "Your leadership will inspire others.",
                "Confidence will lead you to success.",
                "Generosity brings unexpected rewards."));
        dailyHoroscopes.put("virgo", Arrays.asList(
                "Focus on details for best results.",
                "A clear plan will lead you forward.",
                "Your analytical skills will shine."));
        dailyHoroscopes.put("libra", Arrays.asList(
                "Balance brings harmony to your day.",
                "Diplomacy will resolve conflicts.",
                "Fair decisions will lead to happiness."));
        dailyHoroscopes.put("scorpio", Arrays.asList(
                "Your passion will drive you to success.",
                "Resourcefulness will solve problems.",
                "Stay determined to achieve your goals."));
        dailyHoroscopes.put("sagittarius", Arrays.asList(
                "Adventure is calling; embrace it.",
                "Optimism will attract positive outcomes.",
                "Trust your intuition on big decisions."));
        dailyHoroscopes.put("capricorn", Arrays.asList(
                "Discipline leads to achievements.",
                "Responsibility will bring respect.",
                "A new opportunity is on the horizon."));
        dailyHoroscopes.put("aquarius", Arrays.asList(
                "Innovation sets you apart.",
                "Think outside the box today.",
                "Independence will bring fulfillment."));
        dailyHoroscopes.put("pisces", Arrays.asList(
                "Trust your intuition for guidance.",
                "Compassion will strengthen relationships.",
                "Creativity will flow effortlessly."));

        Random random = new Random();
        List<String> horoscopes = dailyHoroscopes.getOrDefault(sign.toLowerCase(), Collections.emptyList());
        return horoscopes.isEmpty() ? "No horoscope available for your sign." : horoscopes.get(random.nextInt(horoscopes.size()));
    }

    public static void main(String[] args) {
        // Lista znaków zodiaku
        List<ZodiacSign> zodiacSigns = new ArrayList<>();
        zodiacSigns.add(new ZodiacSign("aries", 21, 3, 20, 4, "Dynamic and active"));
        zodiacSigns.add(new ZodiacSign("taurus", 21, 4, 20, 5, "Dependable and strong"));
        zodiacSigns.add(new ZodiacSign("gemini", 21, 5, 21, 6, "Curious and adaptable"));
        zodiacSigns.add(new ZodiacSign("cancer", 22, 6, 22, 7, "Emotional and nurturing"));
        zodiacSigns.add(new ZodiacSign("leo", 23, 7, 22, 8, "Confident and generous"));
        zodiacSigns.add(new ZodiacSign("virgo", 23, 8, 22, 9, "Practical and analytical"));
        zodiacSigns.add(new ZodiacSign("libra", 23, 9, 22, 10, "Diplomatic and fair-minded"));
        zodiacSigns.add(new ZodiacSign("scorpio", 23, 10, 21, 11, "Passionate and resourceful"));
        zodiacSigns.add(new ZodiacSign("sagittarius", 22, 11, 21, 12, "Adventurous and optimistic"));
        zodiacSigns.add(new ZodiacSign("capricorn", 22, 12, 19, 1, "Disciplined and responsible"));
        zodiacSigns.add(new ZodiacSign("aquarius", 20, 1, 18, 2, "Innovative and independent"));
        zodiacSigns.add(new ZodiacSign("pisces", 19, 2, 20, 3, "Compassionate and intuitive"));

        // Tworzenie obiektu Scanner do interakcji z użytkownikiem
        Scanner scanner = new Scanner(System.in);

        // Interakcja z użytkownikiem
        System.out.println("Copywriter Melnyk Danylo");
        System.out.println("Enter your birth date (dd.mm):");
        String inputDate = scanner.nextLine().trim();

        // Sprawdzenie poprawności wprowadzonej daty
        String[] dateParts = inputDate.split("\\.");
        if (dateParts.length != 2) {
            System.out.println("Invalid date format. Please try again.");
            return;
        }

        int day, month;
        try {
            day = Integer.parseInt(dateParts[0]);
            month = Integer.parseInt(dateParts[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid day or month value. Please try again.");
            return;
        }

        // Sprawdzenie i określenie znaku zodiaku
        boolean found = false;
        for (ZodiacSign sign : zodiacSigns) {
            if (sign.isDateWithinRange(day, month)) {
                System.out.println("Your zodiac sign: " + sign.name);
                System.out.println("Sign description: " + sign.description);

                // Uzyskanie horoskopu dla znalezionego znaku
                String horoscope = generateHoroscope(sign.name);
                System.out.println("Your daily horoscope: " + horoscope);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Zodiac sign not found.");
        }
    }
}
































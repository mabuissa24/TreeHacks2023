package com.example.HAY;

public class Activities {
    public static String[] categories = {"Relaxation", "Awareness",
            "Physical Health", "CBT Exercises", "Social Connection"};

    public static String[][] IDs = {{"BoxBreathing", "Senses", "Meditate", "BodyScan",
            "MuscleRelaxation"}, {"Journal", "Grateful", "Happy", "Memory"},
            {"Hydrate", "Dance", "Move"}, {"Anxiety"}, {"ReachOut"}};

    public static String[][][] activities = {{{"Take one minute to do ", "box breathing", "!"},
            {"What is one thing you can notice with each sense?", "", ""},
            {"Take one minute to ", "meditate", "."},
            {"Do a ", "body scan", "."}, {"Do ", "progressive muscle relaxation", "."}},
            {{"Take a minute to ", "journal", "."},
                    {"What's one thing you're ", "grateful", " for?"},
                    {"What's something that made you happy recently?", "", ""},
                    {"Write about a fond memory.", "", ""}},
            {{"Drink some water!", "", ""}, {"Choose a song and dance for a few minutes!", "", ""},
                    {"Move around or do an exercise of your choice for a minute!", "", ""}},
            {{"What's something you're ", "anxious",
                    "about? Follow that train of thought to its conclusion."}},
            {{"Send a short message to a family member or friend.", "", ""}}};

    public static String[] getCategories() {
        return categories;
    }

    public static String[] getIDs(String category) {
        for (int i = 0; i < categories.length; i++) {
            if (categories[i].equals(category)) {
                return IDs[i];
            }
        }
        return null;
    }

    public static String[] getActivity(String category, String ID) {
        for (int i = 0; i < categories.length; i++) {
            if (categories[i].equals(category)) {
                for (int j = 0; j < IDs.length; i++) {
                    if (IDs[i][j].equals(ID)) {
                        return activities[i][j];
                    }
                }
            }
        }
        return null;
    }
}

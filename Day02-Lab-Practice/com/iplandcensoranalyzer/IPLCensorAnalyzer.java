package com.iplandcensoranalyzer;

import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

// This class processes IPL match data by applying censorship rules
// and writing the sanitized data to new files.
public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        try {
            // Read JSON and CSV input files
            String jsonContent = new String(Files.readAllBytes(Paths.get("ipl_matches.json")));
            List<String> csvLines = Files.readAllLines(Paths.get("ipl_matches.csv"));

            // Process JSON Data
            JSONArray jsonArray = new JSONArray(jsonContent);
            JSONArray censoredJsonArray = applyCensorshipToJson(jsonArray);

            // Process CSV Data
            List<String> censoredCsvLines = applyCensorshipToCsv(csvLines);

            // Write Censored JSON to a new file
            try (FileWriter file = new FileWriter("ipl_matches_censored.json")) {
                file.write(censoredJsonArray.toString(4));
            }

            // Write Censored CSV to a new file
            try (FileWriter file = new FileWriter("ipl_matches_censored.csv")) {
                for (String line : censoredCsvLines) {
                    file.write(line + "\n");
                }
            }

            System.out.println("Censorship Applied! Censored files generated.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This method applies censorship rules to a JSON array of IPL matches.
    private static JSONArray applyCensorshipToJson(JSONArray jsonArray) {
        // Create a new JSON array to store censored data
        JSONArray censoredArray = new JSONArray();

        // Process each match in the JSON array
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject match = jsonArray.getJSONObject(i);
            JSONObject censoredMatch = new JSONObject(match.toString());

            // Apply censorship to team names
            censoredMatch.put("team1", maskTeamName(match.getString("team1")));
            censoredMatch.put("team2", maskTeamName(match.getString("team2")));
            censoredMatch.put("winner", maskTeamName(match.getString("winner")));

            // Apply censorship to scores
            JSONObject score = match.getJSONObject("score");
            JSONObject censoredScore = new JSONObject();
            for (String team : score.keySet()) {
                censoredScore.put(maskTeamName(team), score.getInt(team));
            }
            censoredMatch.put("score", censoredScore);

            // Apply censorship to Player of the Match
            censoredMatch.put("player_of_match", "REDACTED");

            // Add the censored match to the new JSON array
            censoredArray.put(censoredMatch);
        }
        return censoredArray;
    }

    // This method applies censorship rules to a list of CSV lines.
    private static List<String> applyCensorshipToCsv(List<String> csvLines) {
        // Create a new list to store censored CSV lines
        StringBuilder censoredCsv = new StringBuilder();

        // Process header line (keep unchanged)
        censoredCsv.append(csvLines.get(0)).append("\n");

        // Process each match record in the CSV file
        for (int i = 1; i < csvLines.size(); i++) {
            String[] columns = csvLines.get(i).split(",");

            // Apply censorship to team names
            columns[1] = maskTeamName(columns[1]);
            columns[2] = maskTeamName(columns[2]);
            columns[5] = maskTeamName(columns[5]);

            // Apply censorship to Player of the Match
            columns[6] = "REDACTED";

            // Append the censored line to the result
            censoredCsv.append(String.join(",", columns)).append("\n");
        }

        // Return the sanitized CSV data as a list of strings
        return Arrays.asList(censoredCsv.toString().split("\n"));
    }

    // This method masks a team name by replacing part of it with "***".
    private static String maskTeamName(String teamName) {
        String[] words = teamName.split(" ");
        if (words.length > 1) {
            return words[0] + " ***";
        }
        return teamName;
    }
}

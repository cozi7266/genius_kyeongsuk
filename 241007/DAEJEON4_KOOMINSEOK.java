package com.example.main;
import com.example.libraries.Bridge;

import java.util.*;

public class Main {
    private static String NICKNAME = "기본코드";
    private static String[][] mapData;  // 맵 정보
    private static Map<String, String[]> allies = new HashMap<>();  // 아군 정보
    private static Map<String, String[]> enemies = new HashMap<>();  // 적군 정보
    private static String[] codes;  // 암호문 정보

    public static void main(String[] args) {
    	Bridge bridge = new Bridge();
        String gameData = bridge.init(NICKNAME);

        // while 반복문: 배틀싸피 메인 프로그램과 클라이언트(이 코드)가 데이터를 계속해서 주고받는 부분
        while (gameData.length() > 0) {
            // 자기 차례가 되어 받은 게임정보를 파싱
        	System.out.printf("----입력데이터----\n%s\n----------------\n", gameData);
            parseData(gameData);

            // 파싱한 데이터를 화면에 출력하여 확인
            System.out.printf("\n[맵 정보] (%d x %d)\n", mapData.length, mapData[0].length);
            for (int i = 0; i < mapData.length; i++) {
                for (int j = 0; j < mapData[i].length; j++) {
                    System.out.printf("%s ", mapData[i][j]);
                }
                System.out.println();
            }

            System.out.printf("\n[아군 정보] (아군 수: %d)\n", allies.size());
            for (String key : allies.keySet()) {
                String[] value = allies.get(key);
                if (key.equals("A")) {
                    System.out.printf("A (내 탱크) - 체력: %s, 방향: %s, 보유한 일반 포탄: %s개, 보유한 대전차 포탄: %s개\n", 
                                      value[0], value[1], value[2], value[3]);
                } else if (key.equals("H")) {
                    System.out.printf("H (아군 포탑) - 체력: %s\n", value[0]);
                } else {
                    System.out.printf("%s (아군 탱크) - 체력: %s\n", key, value[0]);
                }
            }

            System.out.printf("\n[적군 정보] (적군 수: %d)\n", enemies.size());
            for (String key : enemies.keySet()) {
                String[] value = enemies.get(key);
                if (key.equals("X")) {
                    System.out.printf("H (적군 포탑) - 체력: %s\n", value[0]);
                } else {
                    System.out.printf("%s (적군 탱크) - 체력: %s\n", key, value[0]);
                }
            }

            System.out.printf("\n[암호문 정보] (암호문 수: %d)\n", codes.length);
            for (int i = 0; i < codes.length; i++) {
                System.out.printf("%s\n", codes[i]);
            }
            

            // 밑에서부터 코드 구현하는 부분
            // 탱크의 동작을 결정하기 위한 알고리즘을 구현하고 원하는 커맨드를 output 변수에 담기
            // 코드 구현 예시: '아래쪽으로 전진'하되, 아래쪽이 지나갈 수 있는 길이 아니라면 '오른쪽로 전진'하라
         // ... (생략: 기존 코드)
            

            // 밑에서부터 코드 구현하는 부분
            // 탱크의 동작을 결정하기 위한 알고리즘을 구현하고 원하는 커맨드를 output 변수에 담기
            String output = "S";  // 알고리즘 결괏값이 없을 경우를 대비하여 초기값을 S로 설정

            int[] myPosition = {-1, -1};
            for (int i = 0; i < mapData.length; i++) {
                for (int j = 0; j < mapData[i].length; j++) {
                    if (mapData[i][j].equals("A")) {
                        myPosition[0] = i;
                        myPosition[1] = j;
                        break;
                    }
                }
                if (myPosition[0] > 0) break;
            }

            // 적군 포탑이나 탱크 위치 파악
            List<int[]> enemyTowersAndTanks = new ArrayList<>();
            for (Map.Entry<String, String[]> entry : enemies.entrySet()) {
                String[] value = entry.getValue();
                // 탱크와 포탑의 위치를 확인
                if (entry.getKey().equals("X") || entry.getKey().matches("[E][0-9]")) {
                    for (int i = 0; i < mapData.length; i++) {
                        for (int j = 0; j < mapData[i].length; j++) {
                            if (mapData[i][j].equals(entry.getKey())) {
                                enemyTowersAndTanks.add(new int[]{i, j});
                            }
                        }
                    }
                }
            }

            // 적군 포탑이나 탱크에 가장 가까운 방향으로 이동 및 공격
            if (!enemyTowersAndTanks.isEmpty()) {
                int targetX = enemyTowersAndTanks.get(0)[0];
                int targetY = enemyTowersAndTanks.get(0)[1];

                // 인접한 포탑 공격
                if (Math.abs(myPosition[0] - targetX) + Math.abs(myPosition[1] - targetY) == 1) {
                    if (mapData[targetX][targetY].equals("X")) {
                        output = "F";  // 포탑 공격
                    } else if (mapData[targetX][targetY].matches("[E][0-9]")) {
                        output = "F S";  // 탱크 공격
                    }
                    // 공격 후 다음 턴 종료
                    gameData = bridge.submit(output);
                    continue;
                }

                // 가능한 이동 방향 찾기 (G 또는 T인 경우)
                List<String> directions = new ArrayList<>();
                if (myPosition[0] < targetX && myPosition[0] + 1 < mapData.length - 1 && !mapData[myPosition[0] + 1][myPosition[1]].equals("F") && !mapData[myPosition[0] + 1][myPosition[1]].equals("W") && !mapData[myPosition[0] + 1][myPosition[1]].equals("R")) {
                    directions.add("D A");  // 아래로 이동
                }
                if (myPosition[0] > targetX && myPosition[0] - 1 > 0 && !mapData[myPosition[0] - 1][myPosition[1]].equals("F") && !mapData[myPosition[0] - 1][myPosition[1]].equals("W") && !mapData[myPosition[0] - 1][myPosition[1]].equals("R")) {
                    directions.add("U A");  // 위로 이동
                }
                if (myPosition[1] < targetY && myPosition[1] + 1 < mapData[0].length && !mapData[myPosition[0]][myPosition[1] + 1].equals("F") && !mapData[myPosition[0]][myPosition[1] + 1].equals("W") && !mapData[myPosition[0]][myPosition[1] + 1].equals("R")) {
                    directions.add("R A");  // 오른쪽으로 이동
                }
                if (myPosition[1] > targetY && myPosition[1] - 1 >= 0 && !mapData[myPosition[0]][myPosition[1] - 1].equals("F") && !mapData[myPosition[0]][myPosition[1] - 1].equals("W") && !mapData[myPosition[0]][myPosition[1] - 1].equals("R")) {
                    directions.add("L A");  // 왼쪽으로 이동
                }

                // 첫 번째 가능한 방향으로 이동
                if (!directions.isEmpty()) {
                    output = directions.get(0); // 첫 번째 방향으로 이동
                }
            } else {
                // 적이 없을 경우 나무를 파괴하여 길을 만들거나 이동
                boolean moved = false;
                for (int[] direction : new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) { // 아래, 위, 오른쪽, 왼쪽
                    int newX = myPosition[0] + direction[0];
                    int newY = myPosition[1] + direction[1];
                    if (newX >= 1 && newX < mapData.length - 1 && newY >= 0 && newY < mapData[0].length) { // 테두리 피하기
                        if (mapData[newX][newY].equals("T")) { // 나무인 경우
                            output = (direction[0] == 1 ? "D" : direction[0] == -1 ? "U" : direction[1] == 1 ? "R" : "L") + " A";  // 나무를 부수기 위해 이동
                            moved = true;
                            break;
                        }
                    }
                }
                if (!moved) {
                    // 나무가 없거나 갈 수 있는 길이 없을 경우 기본적인 이동 로직
                    if (myPosition[0] < mapData.length - 1 && mapData[myPosition[0] + 1][myPosition[1]].equals("G")) {
                        output = "D A";  // 아래로 전진
                    } else {
                        output = "R A";  // 오른쪽으로 전진
                    }
                }
            }

            // while 문의 끝에는 다음 코드가 필수로 존재하여야 함
            // output에 담긴 값은 submit 함수를 통해 배틀싸피 메인 프로그램에 전달
            gameData = bridge.submit(output);
        }

        // 반복문을 빠져나왔을 때 배틀싸피 메인 프로그램과의 연결을 완전히 해제하기 위해 close 함수 호출
        bridge.close();

    }
    // 입력 데이터를 파싱하여 변수에 저장
    static void parseData(String gameData) {
    	// 입력 데이터를 행으로 나누기
        String[] rows = gameData.split("\n");
        int rowIndex = 0;

        // 첫 번째 행 데이터 읽기
        String[] header = rows[rowIndex].split(" ");
        int mapHeight = Integer.parseInt(header[0]);  // 맵의 세로 크기
        int mapWidth = Integer.parseInt(header[1]);  // 맵의 가로 크기
        int numOfAllies = Integer.parseInt(header[2]);  // 아군의 수
        int numOfEnemies = Integer.parseInt(header[3]);  // 적군의 수
        int numOfCodes = Integer.parseInt(header[4]);  // 암호문의 수
        rowIndex++;

        // 기존의 맵 정보를 초기화하고 다시 읽어오기
        mapData = new String[mapHeight][mapWidth];
        for (int i = 0; i < mapHeight; i++) {
            mapData[i] = rows[rowIndex + i].split(" ");
            
        }
        rowIndex += mapHeight;

        // 기존의 아군 정보를 초기화하고 다시 읽어오기
        allies.clear();
        for (int i = 0; i < numOfAllies; i++) {
            String[] allyData = rows[rowIndex + i].split(" ");
            String allyName = allyData[0];
            String[] allyInfo = Arrays.copyOfRange(allyData, 1, allyData.length);
            allies.put(allyName, allyInfo);
        }
        rowIndex += numOfAllies;

        // 기존의 적군 정보를 초기화하고 다시 읽어오기
        enemies.clear();
        for (int i = 0; i < numOfEnemies; i++) {
            String[] enemyData = rows[rowIndex + i].split(" ");
            String enemyName = enemyData[0];
            String[] enemyInfo = Arrays.copyOfRange(enemyData, 1, enemyData.length);
            enemies.put(enemyName, enemyInfo);
        }
        rowIndex += numOfEnemies;

        // 기존의 암호문 정보를 초기화하고 다시 읽어오기
        codes = new String[numOfCodes];
        for (int i = 0; i < numOfCodes; i++) {
            codes[i] = rows[rowIndex + i];
        }
    }
}
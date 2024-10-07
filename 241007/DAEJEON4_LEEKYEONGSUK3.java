package com.example.main;
import com.example.libraries.Bridge;

import java.util.*;

public class DAEJEON4_LEEKYEONGSUK3 {
    private static String NICKNAME = "대전4반_이경석";
    private static String[][] mapData;  // 맵 정보
    private static Map<String, String[]> allies = new HashMap<>();  // 아군 정보
    private static Map<String, String[]> enemies = new HashMap<>();  // 적군 정보
    private static String[] codes;  // 암호문 정보
    private static Set<String> visitedPositions = new HashSet<>();  // 방문한 위치 저장

    public static void main(String[] args) {
        Bridge bridge = new Bridge();
        String gameData = bridge.init(NICKNAME);

        // while 반복문: 배틀싸피 메인 프로그램과 클라이언트(이 코드)가 데이터를 계속해서 주고받는 부분
        while (gameData.length() > 0) {
            // 자기 차례가 되어 받은 게임정보를 파싱
            parseData(gameData);

            // 탱크의 동작을 결정하기 위한 알고리즘을 구현하고 원하는 커맨드를 output 변수에 담기
            String output = "S";  // 초기값을 '정지'로 설정

            int[] myPosition = findMyPosition();
            if (myPosition[0] == -1) {
                gameData = bridge.submit(output);
                continue;
            }

            // 현재 위치를 방문한 위치로 저장
            visitedPositions.add(myPosition[0] + "," + myPosition[1]);

            int[] closestEnemyPosition = findClosestEnemy(myPosition);

            if (closestEnemyPosition != null) {
                int enemyRow = closestEnemyPosition[0];
                int enemyCol = closestEnemyPosition[1];
                String enemyType = mapData[enemyRow][enemyCol];

                // 공격 가능 여부 판단 (적군이 바로 인접해 있는지 확인)
                if (isEnemyAdjacent(myPosition, enemyRow, enemyCol)) {
                    if (enemyType.contains("X")) {
                        output = "F M";  // 적군 포탑일 경우 일반 포탄 발사
                    } else if (enemyType.contains("E")) {
                        output = "F S";  // 적군 탱크일 경우 대전차 포탄 발사
                    }
                } else {
                    // 적군 쪽으로 이동 (이동 가능 여부 확인 후 이동)
                    output = moveTowardsEnemyAvoidStuck(myPosition, enemyRow, enemyCol);
                }
            } else {
                // 적이 없을 경우 기본 동작 (임의로 이동)
                output = exploreMapWithBacktracking(myPosition);
            }

            // while 문의 끝에는 다음 코드가 필수로 존재하여야 함
            // output에 담긴 값은 submit 함수를 통해 배틀싸피 메인 프로그램에 전달
            gameData = bridge.submit(output);

            // 맵 상태 갱신을 위해 방문 위치 초기화
            visitedPositions.clear();
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

    // 내 탱크의 위치 찾기
    static int[] findMyPosition() {
        for (int i = 0; i < mapData.length; i++) {
            for (int j = 0; j < mapData[i].length; j++) {
                if (mapData[i][j].equals("A")) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // 가장 가까운 적 위치 찾기
    static int[] findClosestEnemy(int[] myPosition) {
        int minDistance = Integer.MAX_VALUE;
        int[] closestEnemy = null;

        for (String key : enemies.keySet()) {
            int[] enemyPosition = findEnemyPosition(key);
            int distance = Math.abs(myPosition[0] - enemyPosition[0]) + Math.abs(myPosition[1] - enemyPosition[1]);
            if (distance < minDistance) {
                minDistance = distance;
                closestEnemy = enemyPosition;
            }
        }
        return closestEnemy;
    }

    // 적 위치 찾기
    static int[] findEnemyPosition(String enemyKey) {
        for (int i = 0; i < mapData.length; i++) {
            for (int j = 0; j < mapData[i].length; j++) {
                if (mapData[i][j].equals(enemyKey)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // 적이 바로 인접해 있는지 확인 (상하좌우 인접한 경우만 공격 가능)
    static boolean isEnemyAdjacent(int[] myPosition, int enemyRow, int enemyCol) {
        int rowDiff = Math.abs(myPosition[0] - enemyRow);
        int colDiff = Math.abs(myPosition[1] - enemyCol);
        return (rowDiff == 1 && colDiff == 0) || (rowDiff == 0 && colDiff == 1);
    }

    // 해당 위치로 이동 가능한지 확인
    static boolean canMoveTo(int row, int col) {
        return row >= 0 && row < mapData.length && col >= 0 && col < mapData[0].length && (mapData[row][col].equals("G") || mapData[row][col].equals("E") || mapData[row][col].equals("X"));
    }

    // 나무를 파괴할 수 있는지 확인하고 파괴
    static boolean destroyTree(int row, int col) {
        if (mapData[row][col].equals("T")) {
            System.out.printf("나무 파괴: 위치 (%d, %d)\n", row, col);
            mapData[row][col] = "G";  // 나무 파괴 후 일반 지형으로 변경
            return true;
        }
        return false;
    }

    // 적군 쪽으로 이동하는 로직 (같은 행 또는 열에서 멈추지 않도록 지속적인 이동 시도)
    static String moveTowardsEnemyAvoidStuck(int[] myPosition, int enemyRow, int enemyCol) {
        List<String> possibleMoves = new ArrayList<>();

        // 적군의 위치와 같은 행 또는 열에 있을 때도 계속 이동 시도
        if (myPosition[0] < enemyRow && canMoveTo(myPosition[0] + 1, myPosition[1])) {
            possibleMoves.add("D A");
        } else if (myPosition[0] < enemyRow && mapData[myPosition[0] + 1][myPosition[1]].equals("T")) {
            destroyTree(myPosition[0] + 1, myPosition[1]);
            return "F M";  // 나무 파괴
        }

        if (myPosition[0] > enemyRow && canMoveTo(myPosition[0] - 1, myPosition[1])) {
            possibleMoves.add("U A");
        } else if (myPosition[0] > enemyRow && mapData[myPosition[0] - 1][myPosition[1]].equals("T")) {
            destroyTree(myPosition[0] - 1, myPosition[1]);
            return "F M";  // 나무 파괴
        }

        if (myPosition[1] < enemyCol && canMoveTo(myPosition[0], myPosition[1] + 1)) {
            possibleMoves.add("R A");
        } else if (myPosition[1] < enemyCol && mapData[myPosition[0]][myPosition[1] + 1].equals("T")) {
            destroyTree(myPosition[0], myPosition[1] + 1);
            return "F M";  // 나무 파괴
        }

        if (myPosition[1] > enemyCol && canMoveTo(myPosition[0], myPosition[1] - 1)) {
            possibleMoves.add("L A");
        } else if (myPosition[1] > enemyCol && mapData[myPosition[0]][myPosition[1] - 1].equals("T")) {
            destroyTree(myPosition[0], myPosition[1] - 1);
            return "F M";  // 나무 파괴
        }

        // 만약 이동할 수 있는 방향이 없다면 다른 방향으로 이동 시도
        if (possibleMoves.isEmpty()) {
            return exploreMapWithBacktracking(myPosition);
        }

        // 가능한 이동 방향 중 첫 번째로 선택하여 이동 (무작위로 선택하지 않고 멈춤 문제 방지)
        return possibleMoves.get(0);
    }

    // 기본적인 맵 탐색 로직 (탱크가 막혔을 때 다른 방향으로 탐색 및 왔던 길을 다시 가도록 백트래킹)
    static String exploreMapWithBacktracking(int[] myPosition) {
        List<String> possibleMoves = new ArrayList<>();

        // 현재 위치에서 갈 수 있는 모든 방향을 추가 (이전에 방문한 위치라도 이동 가능하도록 함)
        if (myPosition[0] < mapData.length - 1 && canMoveTo(myPosition[0] + 1, myPosition[1])) {
            possibleMoves.add("D A");
        }
        if (myPosition[1] < mapData[0].length - 1 && canMoveTo(myPosition[0], myPosition[1] + 1)) {
            possibleMoves.add("R A");
        }
        if (myPosition[1] > 0 && canMoveTo(myPosition[0], myPosition[1] - 1)) {
            possibleMoves.add("L A");
        }
        if (myPosition[0] > 0 && canMoveTo(myPosition[0] - 1, myPosition[1])) {
            possibleMoves.add("U A");
        }

        // 가능한 이동 방향 중 첫 번째로 선택하여 이동 (무작위로 선택하지 않고 멈춤 문제 방지)
        if (!possibleMoves.isEmpty()) {
            return possibleMoves.get(0);
        }

        // 만약 이동할 수 있는 방향이 없다면 정지
        return "S";
    }

    // 추가 기능: 주변의 자원 수집
    static void collectResources(int[] myPosition) {
        System.out.println("자원 수집 기능 실행 중...");
        // 예시 로직: 주변 1칸 이내에 'R' 표시가 있는 경우 자원 수집
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = myPosition[0] + i;
                int newCol = myPosition[1] + j;
                if (newRow >= 0 && newRow < mapData.length && newCol >= 0 && newCol < mapData[0].length) {
                    if (mapData[newRow][newCol].equals("R")) {
                        System.out.printf("자원 수집: 위치 (%d, %d)\n", newRow, newCol);
                    }
                }
            }
        }
    }
} 
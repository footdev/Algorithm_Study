package hyeonsu.boj;

import java.util.*;
import java.io.*;

public class BOJ9205 {

    final static int MANHATTAN_DIST_INIT = 1000;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int t, n;
    static boolean arrival;

    static Point f;
    static Point[] stores;
    static boolean[] v;
    static SangGeun sg;

    public static void main(String[] args) throws IOException {

        t = stoi(br.readLine());

        while (t-- > 0) {
            // 초기화
            n = stoi(br.readLine());
            stores = new Point[n];
            v = new boolean[n];
            arrival = false;

            // 상근이 좌표
            st = new StringTokenizer(br.readLine());
            Point sgPoint = new Point(stoi(st.nextToken()), stoi(st.nextToken()));

            //상근 정보 저장
            sg = new SangGeun(sgPoint);

            // 편의점 좌표
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                stores[i] = new Point(stoi(st.nextToken()), stoi(st.nextToken()));
            }

            // 펜타포트 락 페스티벌 좌표
            st = new StringTokenizer(br.readLine());
            f = new Point(stoi(st.nextToken()), stoi(st.nextToken()));

            // 로직
            bfs();

            // 정답 저장
            bw.write(arrival ? "happy" : "sad");
            bw.write("\n");
        }

        //출력
        bw.flush();
    }

    static int stoi(String s) {return Integer.parseInt(s);}

    static void bfs() {

        // 이미 도달 했으므로 return
        if (arrival) return;

        // 상근이 현재 좌표로부터 남은 맥주 * 50 맨하튼 거리 이내에 페스티발이 있다면 true return
        int distGap = sg.getDistGap(f);
        if (distGap <= sg.distCnt) {
            arrival = true;
            return;
        }

        // 남은 맥주 내에 페스티발에 갈 수 없다면 편의점부터 들른다.
        for (int i = 0; i < n; i++) {
            distGap = sg.getDistGap(stores[i]);
            // 상근이 현재 좌표로부터 남은 맥주 * 50 맨하튼 거리 이내에 편의점이 있다면 일단 간다.
            if (!v[i] && distGap <= sg.distCnt) {
                Point p = sg.p;
                int distCnt = sg.distCnt;
                sg.walk(stores[i]);
                v[i] = true;
                bfs();
                sg.walk(p);
                sg.distCnt = distCnt;
                v[i] = false;
            }
        }
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDistGap(Point o) {
            return (Math.abs(this.x - o.x)) + (Math.abs(this.y - o.y));
        }


        @Override
        public int compareTo(Point o) {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {

        }
    }

    static class SangGeun {
        Point p;
        int distCnt;

        public SangGeun(Point p) {
            this.p = p;
            this.distCnt = MANHATTAN_DIST_INIT;
        }

        public void walk(Point store) {
            distCnt = MANHATTAN_DIST_INIT;
            this.p.x = store.x;
            this.p.y = store.y;
        }

        public int getDistGap(Point o) {
            return p.getDistGap(o);
        }
    }
}

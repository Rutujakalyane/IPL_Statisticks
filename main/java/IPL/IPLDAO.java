package IPL;

public class IPLDAO {
    public class IPLDAO {

        private String PLAYER;
        private Integer Mat;
        private Integer Runs;
        private Double Avg;
        private Double SR;
        private Integer Fours;
        private Integer Sixes;

        public IPLDAO() {

        }

        public IPLDAO(IPLRunsCSV IPLRunsCSV) {
            this.PLAYER = IPLRunsCSV.PLAYER;
            this.Mat = IPLRunsCSV.Mat;
            this.Runs = IPLRunsCSV.Runs;
            this.Avg = IPLRunsCSV.Avg;
            this.SR = IPLRunsCSV.SR;
            this.Fours = IPLRunsCSV.Fours;
            this.Sixes = IPLRunsCSV.Sixes;
        }
    }
}

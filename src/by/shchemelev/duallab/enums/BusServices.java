package by.shchemelev.duallab.enums;

public enum BusServices implements Priorable{
    Grotty{
        public int getPriority(){
            return 0;
        }
    },
    Posh{
        public int getPriority(){
            return 1;
        }
    }
}

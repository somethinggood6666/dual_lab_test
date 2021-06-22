package by.shchemelev.duallab.enums;

public enum BusServices implements Priorable{

    //we need each service priority to choose the service
    //if arrival and departure times are equals
    Grotty{
        @Override
        public int getPriority(){
            return 0;
        }
    },
    Posh{
        @Override
        public int getPriority(){
            return 1;
        }
    }
}

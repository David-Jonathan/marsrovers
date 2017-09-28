package com.au.covata.marsrovers.util;

public enum RoverDirection {

    N{
        @Override
        public RoverDirection left() {
            return W;
        }

        @Override
        public RoverDirection right() {
            return E;
        }
    },
   S{
        @Override
        public RoverDirection right() {
            return W;
        }

        @Override
        public RoverDirection left() {
            return E;
        }
    },
    E{
        @Override
        public RoverDirection right() {
            return S;
        }

        @Override
        public RoverDirection left() {
            return N;
        }
    },
    W{
        @Override
        public RoverDirection right() {
            return N;
        }

        @Override
        public RoverDirection left() {
            return S;
        }
    };

    public abstract RoverDirection right();
    public abstract RoverDirection left();

}
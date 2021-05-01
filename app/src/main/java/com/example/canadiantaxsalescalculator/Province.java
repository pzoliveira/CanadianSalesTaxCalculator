package com.example.canadiantaxsalescalculator;

public enum Province {
    Alberta{
        @Override
        public double getTaxPercentage() {
            return .05;
        }
    },
    British_Columbia{
        @Override
        public double getTaxPercentage() {
            return .12;
        }
    },
    Manitoba{
        @Override
        public double getTaxPercentage() {
            return .13;
        }
    },
    News_Brunswick{
        @Override
        public double getTaxPercentage() {
            return .15;
        }
    },
    Newfoundland_and_Labrador{
        @Override
        public double getTaxPercentage() {
            return .15;
        }
    },
    Northwest_Territories{
        @Override
        public double getTaxPercentage() {
            return .05;
        }
    },
    Nova_Scotia{
        @Override
        public double getTaxPercentage() {
            return .15;
        }
    },
    Nunavut{
        @Override
        public double getTaxPercentage() {
            return .05;
        }
    },
    Ontario{
        @Override
        public double getTaxPercentage() {
            return .13;
        }
    },
    Prince_Edward_Island{
        @Override
        public double getTaxPercentage() {
            return .14;
        }
    },
    Quebec{
        @Override
        public double getTaxPercentage() {
            return .15;
        }
    },
    Saskatchewan{
        @Override
        public double getTaxPercentage() {
            return .10;
        }
    },
    Yukon{
        @Override
        public double getTaxPercentage() {
            return .05;
        }
    };

    public abstract double getTaxPercentage();
}

package com.example.josh.lab7;

import android.provider.BaseColumns;

/**
 * Created by Josh on 3/21/2018.
 */

public class TeamDbSchema {
    public static final class TeamsTable {
        public static final class Cols implements BaseColumns {
            public static final String TABLE_NAME = "teams";
            public static final String COLUMN_NAME_MANAGER = "managerName";
            public static final String COLUMN_NAME_MEMBERS = "teamMembers";
        }
    }

}

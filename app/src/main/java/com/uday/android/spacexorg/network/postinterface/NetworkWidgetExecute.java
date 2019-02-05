package com.uday.android.spacexorg.network.postinterface;

import com.uday.android.spacexorg.network.model.launch.Launch;

public interface NetworkWidgetExecute {
    void getNextLaunch(Launch nextLaunch, Boolean isExecuted);
}

package com.example.testroom.BPM;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\rH\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&H\u0016J\u0012\u0010\'\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\b\u0010*\u001a\u00020\u001eH\u0014J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\tH\u0016J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\rH\u0016J\u0010\u0010/\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\rH\u0016J\u0010\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020\u001e2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u000206H\u0016J0\u00107\u001a\u00020\u001e2\u0006\u00105\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020\rH\u0016J\u0018\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\rH\u0016J\u0010\u0010D\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\rH\u0016J \u0010E\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020:H\u0016J\b\u0010I\u001a\u00020\u001eH\u0014J\b\u0010J\u001a\u00020\u001eH\u0014J\u0018\u0010K\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\r2\u0006\u0010,\u001a\u00020\tH\u0016J\b\u0010L\u001a\u00020\u001eH\u0002R\u0014\u0010\b\u001a\u00020\tX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006M"}, d2 = {"Lcom/example/testroom/BPM/BPMTestActivity;", "Landroidx/activity/ComponentActivity;", "Lcom/ideabus/model/protocol/BPMProtocol$OnConnectStateListener;", "Landroid/view/View$OnClickListener;", "Lcom/ideabus/model/protocol/BPMProtocol$OnDataResponseListener;", "Lcom/ideabus/model/protocol/BPMProtocol$OnNotifyStateListener;", "Lcom/ideabus/model/bluetooth/MyBluetoothLE$OnWriteStateListener;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isConnecting", "", "()Z", "setConnecting", "(Z)V", "logListAdapter", "Lcom/example/testroom/LogListAdapter;", "getLogListAdapter", "()Lcom/example/testroom/LogListAdapter;", "setLogListAdapter", "(Lcom/example/testroom/LogListAdapter;)V", "vm", "Lcom/example/testroom/BPM/BPMViewModel;", "getVm", "()Lcom/example/testroom/BPM/BPMViewModel;", "vm$delegate", "Lkotlin/Lazy;", "initParam", "", "onBtStateChanged", "isEnable", "onClick", "v", "Landroid/view/View;", "onConnectionState", "state", "Lcom/ideabus/model/protocol/BPMProtocol$ConnectState;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyMessage", "message", "onResponseClearHistory", "isSuccess", "onResponseClearLastData", "onResponseReadDeviceInfo", "deviceInfo", "Lcom/ideabus/model/data/DeviceInfo;", "onResponseReadDeviceTime", "onResponseReadHistory", "dRecord", "Lcom/ideabus/model/data/DRecord;", "onResponseReadLastData", "Lcom/ideabus/model/data/CurrentAndMData;", "historyMeasuremeNumber", "", "userNumber", "MAMState", "isNoData", "onResponseReadUserAndVersionData", "user", "Lcom/ideabus/model/data/User;", "versionData", "Lcom/ideabus/model/data/VersionData;", "onResponseWriteDeviceTime", "onResponseWriteUser", "onScanResult", "mac", "name", "rssi", "onStart", "onStop", "onWriteMessage", "startScan", "app_debug"})
public final class BPMTestActivity extends androidx.activity.ComponentActivity implements com.ideabus.model.protocol.BPMProtocol.OnConnectStateListener, android.view.View.OnClickListener, com.ideabus.model.protocol.BPMProtocol.OnDataResponseListener, com.ideabus.model.protocol.BPMProtocol.OnNotifyStateListener, com.ideabus.model.bluetooth.MyBluetoothLE.OnWriteStateListener {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "BPMTestActivity";
    @org.jetbrains.annotations.Nullable()
    private com.example.testroom.LogListAdapter logListAdapter;
    private boolean isConnecting = false;
    private final kotlin.Lazy vm$delegate = null;
    
    public BPMTestActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.testroom.LogListAdapter getLogListAdapter() {
        return null;
    }
    
    public final void setLogListAdapter(@org.jetbrains.annotations.Nullable()
    com.example.testroom.LogListAdapter p0) {
    }
    
    public final boolean isConnecting() {
        return false;
    }
    
    public final void setConnecting(boolean p0) {
    }
    
    private final com.example.testroom.BPM.BPMViewModel getVm() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initParam() {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    private final void startScan() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @java.lang.Override()
    public void onWriteMessage(boolean isSuccess, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    public void onNotifyMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    public void onResponseReadHistory(@org.jetbrains.annotations.NotNull()
    com.ideabus.model.data.DRecord dRecord) {
    }
    
    @java.lang.Override()
    public void onResponseClearHistory(boolean isSuccess) {
    }
    
    @java.lang.Override()
    public void onResponseReadUserAndVersionData(@org.jetbrains.annotations.NotNull()
    com.ideabus.model.data.User user, @org.jetbrains.annotations.NotNull()
    com.ideabus.model.data.VersionData versionData) {
    }
    
    @java.lang.Override()
    public void onResponseWriteUser(boolean isSuccess) {
    }
    
    @java.lang.Override()
    public void onResponseReadLastData(@org.jetbrains.annotations.NotNull()
    com.ideabus.model.data.CurrentAndMData dRecord, int historyMeasuremeNumber, int userNumber, int MAMState, boolean isNoData) {
    }
    
    @java.lang.Override()
    public void onResponseClearLastData(boolean isSuccess) {
    }
    
    @java.lang.Override()
    public void onResponseReadDeviceInfo(@org.jetbrains.annotations.NotNull()
    com.ideabus.model.data.DeviceInfo deviceInfo) {
    }
    
    @java.lang.Override()
    public void onResponseWriteDeviceTime(boolean isSuccess) {
    }
    
    @java.lang.Override()
    public void onResponseReadDeviceTime(@org.jetbrains.annotations.NotNull()
    com.ideabus.model.data.DeviceInfo deviceInfo) {
    }
    
    @java.lang.Override()
    public void onBtStateChanged(boolean isEnable) {
    }
    
    @java.lang.Override()
    public void onScanResult(@org.jetbrains.annotations.NotNull()
    java.lang.String mac, @org.jetbrains.annotations.NotNull()
    java.lang.String name, int rssi) {
    }
    
    @java.lang.Override()
    public void onConnectionState(@org.jetbrains.annotations.NotNull()
    com.ideabus.model.protocol.BPMProtocol.ConnectState state) {
    }
}
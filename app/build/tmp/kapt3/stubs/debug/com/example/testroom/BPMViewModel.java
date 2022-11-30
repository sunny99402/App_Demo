package com.example.testroom;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\nJ\u0006\u0010/\u001a\u00020-J\u000e\u0010\u0015\u001a\u00020-2\u0006\u00100\u001a\u00020\"J\u0015\u0010\u001d\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u0019H\u0007\u00a2\u0006\u0002\b1R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R+\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00198F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010#\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\"8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\'\u0010\u0018\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001d\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0010R\u001d\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u000e8F\u00a2\u0006\u0006\u001a\u0004\b+\u0010\u0010\u00a8\u00062"}, d2 = {"Lcom/example/testroom/BPMViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_bpmListData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/testroom/Room/BPM;", "_logListData", "", "bpmDao", "Lcom/example/testroom/Room/BPMDao;", "bpmListData", "Landroidx/lifecycle/LiveData;", "getBpmListData", "()Landroidx/lifecycle/LiveData;", "<set-?>", "connectState", "getConnectState", "()Ljava/lang/String;", "setConnectState", "(Ljava/lang/String;)V", "connectState$delegate", "Landroidx/compose/runtime/MutableState;", "Lcom/ideabus/model/data/DRecord;", "dRecord", "getDRecord", "()Lcom/ideabus/model/data/DRecord;", "setDRecord", "(Lcom/ideabus/model/data/DRecord;)V", "dRecord$delegate", "database", "Lcom/example/testroom/Room/MyDatabase;", "", "isConnected", "()Z", "setConnected", "(Z)V", "isConnected$delegate", "liveData", "getLiveData", "logListData", "getLogListData", "addLogData", "", "param", "insertDatabase", "b", "setDRecord1", "app_debug"})
public final class BPMViewModel extends androidx.lifecycle.AndroidViewModel {
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> _logListData = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.testroom.Room.BPM>> _bpmListData = null;
    private final com.example.testroom.Room.MyDatabase database = null;
    private final com.example.testroom.Room.BPMDao bpmDao = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.testroom.Room.BPM>> liveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState isConnected$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState connectState$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState dRecord$delegate = null;
    
    public BPMViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getLogListData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.testroom.Room.BPM>> getBpmListData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.testroom.Room.BPM>> getLiveData() {
        return null;
    }
    
    public final boolean isConnected() {
        return false;
    }
    
    public final void setConnected(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getConnectState() {
        return null;
    }
    
    public final void setConnectState(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ideabus.model.data.DRecord getDRecord() {
        return null;
    }
    
    public final void setDRecord(@org.jetbrains.annotations.NotNull()
    com.ideabus.model.data.DRecord p0) {
    }
    
    public final void addLogData(@org.jetbrains.annotations.NotNull()
    java.lang.String param) {
    }
    
    public final void setConnectState(boolean b) {
    }
    
    @kotlin.jvm.JvmName(name = "setDRecord1")
    public final void setDRecord1(@org.jetbrains.annotations.NotNull()
    com.ideabus.model.data.DRecord dRecord) {
    }
    
    public final void insertDatabase() {
    }
}
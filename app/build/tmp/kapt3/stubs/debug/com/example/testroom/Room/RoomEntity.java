package com.example.testroom.Room;

import java.lang.System;

@androidx.room.Entity(tableName = "bpm_entity")
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b-\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001<B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001e\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001e\u0010$\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R \u0010\'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001e\u0010*\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R \u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR \u00100\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001e\u00103\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0012\"\u0004\b5\u0010\u0014R \u00106\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u001e\u00109\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\b\u00a8\u0006="}, d2 = {"Lcom/example/testroom/Room/RoomEntity;", "", "()V", "accountId", "", "getAccountId", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "afib", "", "getAfib", "()Z", "setAfib", "(Z)V", "cuffokr", "", "getCuffokr", "()I", "setCuffokr", "(I)V", "date", "getDate", "setDate", "dia", "getDia", "setDia", "id", "getId", "setId", "mam", "getMam", "setMam", "note", "getNote", "setNote", "pad", "getPad", "setPad", "photoPath", "getPhotoPath", "setPhotoPath", "pul", "getPul", "setPul", "recordTime", "getRecordTime", "setRecordTime", "recordingPath", "getRecordingPath", "setRecordingPath", "sys", "getSys", "setSys", "timePeriod", "getTimePeriod", "setTimePeriod", "userNumber", "getUserNumber", "setUserNumber", "Companion", "app_debug"})
public final class RoomEntity {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.testroom.Room.RoomEntity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TABLE_NAME = "bpm_entity";
    @androidx.room.ColumnInfo(name = "_id")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id = 0;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "USER_NUMBER")
    private java.lang.String userNumber = "";
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "ACCOUNT_ID")
    private java.lang.String accountId = "";
    @androidx.room.ColumnInfo(name = "SYS")
    private int sys = 0;
    @androidx.room.ColumnInfo(name = "DIA")
    private int dia = 0;
    @androidx.room.ColumnInfo(name = "PUL")
    private int pul = 0;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "DATE")
    private java.lang.String date = "";
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "AM__PM")
    private java.lang.String timePeriod = "";
    @androidx.room.ColumnInfo(name = "AFIB")
    private boolean afib = false;
    @androidx.room.ColumnInfo(name = "PAD")
    private int pad = 0;
    @androidx.room.ColumnInfo(name = "MAN")
    private int mam = 0;
    @androidx.room.ColumnInfo(name = "CUFFOKR")
    private int cuffokr = 0;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "PHOTO_PATH")
    private java.lang.String photoPath = "";
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "NOTE")
    private java.lang.String note = "";
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "RECORDING_PATH")
    private java.lang.String recordingPath = "";
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "RECORD_TIME")
    private java.lang.String recordTime = "";
    
    public RoomEntity() {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserNumber() {
        return null;
    }
    
    public final void setUserNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAccountId() {
        return null;
    }
    
    public final void setAccountId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getSys() {
        return 0;
    }
    
    public final void setSys(int p0) {
    }
    
    public final int getDia() {
        return 0;
    }
    
    public final void setDia(int p0) {
    }
    
    public final int getPul() {
        return 0;
    }
    
    public final void setPul(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDate() {
        return null;
    }
    
    public final void setDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTimePeriod() {
        return null;
    }
    
    public final void setTimePeriod(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean getAfib() {
        return false;
    }
    
    public final void setAfib(boolean p0) {
    }
    
    public final int getPad() {
        return 0;
    }
    
    public final void setPad(int p0) {
    }
    
    public final int getMam() {
        return 0;
    }
    
    public final void setMam(int p0) {
    }
    
    public final int getCuffokr() {
        return 0;
    }
    
    public final void setCuffokr(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPhotoPath() {
        return null;
    }
    
    public final void setPhotoPath(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNote() {
        return null;
    }
    
    public final void setNote(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRecordingPath() {
        return null;
    }
    
    public final void setRecordingPath(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRecordTime() {
        return null;
    }
    
    public final void setRecordTime(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/testroom/Room/RoomEntity$Companion;", "", "()V", "TABLE_NAME", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}
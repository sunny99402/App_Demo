package com.example.testroom.Room;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RoomDao_Impl implements RoomDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<RoomEntity> __insertionAdapterOfRoomEntity;

  private final EntityInsertionAdapter<RoomEntity> __insertionAdapterOfRoomEntity_1;

  private final EntityDeletionOrUpdateAdapter<RoomEntity> __deletionAdapterOfRoomEntity;

  private final EntityDeletionOrUpdateAdapter<RoomEntity> __updateAdapterOfRoomEntity;

  public RoomDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRoomEntity = new EntityInsertionAdapter<RoomEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `bpm_entity` (`_id`,`USER_NUMBER`,`ACCOUNT_ID`,`SYS`,`DIA`,`PUL`,`DATE`,`AM__PM`,`AFIB`,`PAD`,`MAN`,`CUFFOKR`,`PHOTO_PATH`,`NOTE`,`RECORDING_PATH`,`RECORD_TIME`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getUserNumber() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUserNumber());
        }
        if (value.getAccountId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAccountId());
        }
        stmt.bindLong(4, value.getSys());
        stmt.bindLong(5, value.getDia());
        stmt.bindLong(6, value.getPul());
        if (value.getDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDate());
        }
        if (value.getTimePeriod() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTimePeriod());
        }
        final int _tmp = value.getAfib() ? 1 : 0;
        stmt.bindLong(9, _tmp);
        stmt.bindLong(10, value.getPad());
        stmt.bindLong(11, value.getMam());
        stmt.bindLong(12, value.getCuffokr());
        if (value.getPhotoPath() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getPhotoPath());
        }
        if (value.getNote() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getNote());
        }
        if (value.getRecordingPath() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getRecordingPath());
        }
        if (value.getRecordTime() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getRecordTime());
        }
      }
    };
    this.__insertionAdapterOfRoomEntity_1 = new EntityInsertionAdapter<RoomEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `bpm_entity` (`_id`,`USER_NUMBER`,`ACCOUNT_ID`,`SYS`,`DIA`,`PUL`,`DATE`,`AM__PM`,`AFIB`,`PAD`,`MAN`,`CUFFOKR`,`PHOTO_PATH`,`NOTE`,`RECORDING_PATH`,`RECORD_TIME`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getUserNumber() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUserNumber());
        }
        if (value.getAccountId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAccountId());
        }
        stmt.bindLong(4, value.getSys());
        stmt.bindLong(5, value.getDia());
        stmt.bindLong(6, value.getPul());
        if (value.getDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDate());
        }
        if (value.getTimePeriod() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTimePeriod());
        }
        final int _tmp = value.getAfib() ? 1 : 0;
        stmt.bindLong(9, _tmp);
        stmt.bindLong(10, value.getPad());
        stmt.bindLong(11, value.getMam());
        stmt.bindLong(12, value.getCuffokr());
        if (value.getPhotoPath() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getPhotoPath());
        }
        if (value.getNote() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getNote());
        }
        if (value.getRecordingPath() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getRecordingPath());
        }
        if (value.getRecordTime() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getRecordTime());
        }
      }
    };
    this.__deletionAdapterOfRoomEntity = new EntityDeletionOrUpdateAdapter<RoomEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `bpm_entity` WHERE `_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfRoomEntity = new EntityDeletionOrUpdateAdapter<RoomEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `bpm_entity` SET `_id` = ?,`USER_NUMBER` = ?,`ACCOUNT_ID` = ?,`SYS` = ?,`DIA` = ?,`PUL` = ?,`DATE` = ?,`AM__PM` = ?,`AFIB` = ?,`PAD` = ?,`MAN` = ?,`CUFFOKR` = ?,`PHOTO_PATH` = ?,`NOTE` = ?,`RECORDING_PATH` = ?,`RECORD_TIME` = ? WHERE `_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getUserNumber() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUserNumber());
        }
        if (value.getAccountId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAccountId());
        }
        stmt.bindLong(4, value.getSys());
        stmt.bindLong(5, value.getDia());
        stmt.bindLong(6, value.getPul());
        if (value.getDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDate());
        }
        if (value.getTimePeriod() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTimePeriod());
        }
        final int _tmp = value.getAfib() ? 1 : 0;
        stmt.bindLong(9, _tmp);
        stmt.bindLong(10, value.getPad());
        stmt.bindLong(11, value.getMam());
        stmt.bindLong(12, value.getCuffokr());
        if (value.getPhotoPath() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getPhotoPath());
        }
        if (value.getNote() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getNote());
        }
        if (value.getRecordingPath() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getRecordingPath());
        }
        if (value.getRecordTime() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getRecordTime());
        }
        stmt.bindLong(17, value.getId());
      }
    };
  }

  @Override
  public long insert(final RoomEntity item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfRoomEntity.insertAndReturnId(item);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final RoomEntity item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfRoomEntity_1.insert(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final RoomEntity item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfRoomEntity.handle(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final RoomEntity item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfRoomEntity.handle(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<RoomEntity>> getAllBPMs() {
    final String _sql = "SELECT * FROM bpm_entity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"bpm_entity"}, false, new Callable<List<RoomEntity>>() {
      @Override
      public List<RoomEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
          final int _cursorIndexOfUserNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "USER_NUMBER");
          final int _cursorIndexOfAccountId = CursorUtil.getColumnIndexOrThrow(_cursor, "ACCOUNT_ID");
          final int _cursorIndexOfSys = CursorUtil.getColumnIndexOrThrow(_cursor, "SYS");
          final int _cursorIndexOfDia = CursorUtil.getColumnIndexOrThrow(_cursor, "DIA");
          final int _cursorIndexOfPul = CursorUtil.getColumnIndexOrThrow(_cursor, "PUL");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "DATE");
          final int _cursorIndexOfTimePeriod = CursorUtil.getColumnIndexOrThrow(_cursor, "AM__PM");
          final int _cursorIndexOfAfib = CursorUtil.getColumnIndexOrThrow(_cursor, "AFIB");
          final int _cursorIndexOfPad = CursorUtil.getColumnIndexOrThrow(_cursor, "PAD");
          final int _cursorIndexOfMam = CursorUtil.getColumnIndexOrThrow(_cursor, "MAN");
          final int _cursorIndexOfCuffokr = CursorUtil.getColumnIndexOrThrow(_cursor, "CUFFOKR");
          final int _cursorIndexOfPhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "PHOTO_PATH");
          final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "NOTE");
          final int _cursorIndexOfRecordingPath = CursorUtil.getColumnIndexOrThrow(_cursor, "RECORDING_PATH");
          final int _cursorIndexOfRecordTime = CursorUtil.getColumnIndexOrThrow(_cursor, "RECORD_TIME");
          final List<RoomEntity> _result = new ArrayList<RoomEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final RoomEntity _item;
            _item = new RoomEntity();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpUserNumber;
            if (_cursor.isNull(_cursorIndexOfUserNumber)) {
              _tmpUserNumber = null;
            } else {
              _tmpUserNumber = _cursor.getString(_cursorIndexOfUserNumber);
            }
            _item.setUserNumber(_tmpUserNumber);
            final String _tmpAccountId;
            if (_cursor.isNull(_cursorIndexOfAccountId)) {
              _tmpAccountId = null;
            } else {
              _tmpAccountId = _cursor.getString(_cursorIndexOfAccountId);
            }
            _item.setAccountId(_tmpAccountId);
            final int _tmpSys;
            _tmpSys = _cursor.getInt(_cursorIndexOfSys);
            _item.setSys(_tmpSys);
            final int _tmpDia;
            _tmpDia = _cursor.getInt(_cursorIndexOfDia);
            _item.setDia(_tmpDia);
            final int _tmpPul;
            _tmpPul = _cursor.getInt(_cursorIndexOfPul);
            _item.setPul(_tmpPul);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            _item.setDate(_tmpDate);
            final String _tmpTimePeriod;
            if (_cursor.isNull(_cursorIndexOfTimePeriod)) {
              _tmpTimePeriod = null;
            } else {
              _tmpTimePeriod = _cursor.getString(_cursorIndexOfTimePeriod);
            }
            _item.setTimePeriod(_tmpTimePeriod);
            final boolean _tmpAfib;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfAfib);
            _tmpAfib = _tmp != 0;
            _item.setAfib(_tmpAfib);
            final int _tmpPad;
            _tmpPad = _cursor.getInt(_cursorIndexOfPad);
            _item.setPad(_tmpPad);
            final int _tmpMam;
            _tmpMam = _cursor.getInt(_cursorIndexOfMam);
            _item.setMam(_tmpMam);
            final int _tmpCuffokr;
            _tmpCuffokr = _cursor.getInt(_cursorIndexOfCuffokr);
            _item.setCuffokr(_tmpCuffokr);
            final String _tmpPhotoPath;
            if (_cursor.isNull(_cursorIndexOfPhotoPath)) {
              _tmpPhotoPath = null;
            } else {
              _tmpPhotoPath = _cursor.getString(_cursorIndexOfPhotoPath);
            }
            _item.setPhotoPath(_tmpPhotoPath);
            final String _tmpNote;
            if (_cursor.isNull(_cursorIndexOfNote)) {
              _tmpNote = null;
            } else {
              _tmpNote = _cursor.getString(_cursorIndexOfNote);
            }
            _item.setNote(_tmpNote);
            final String _tmpRecordingPath;
            if (_cursor.isNull(_cursorIndexOfRecordingPath)) {
              _tmpRecordingPath = null;
            } else {
              _tmpRecordingPath = _cursor.getString(_cursorIndexOfRecordingPath);
            }
            _item.setRecordingPath(_tmpRecordingPath);
            final String _tmpRecordTime;
            if (_cursor.isNull(_cursorIndexOfRecordTime)) {
              _tmpRecordTime = null;
            } else {
              _tmpRecordTime = _cursor.getString(_cursorIndexOfRecordTime);
            }
            _item.setRecordTime(_tmpRecordTime);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

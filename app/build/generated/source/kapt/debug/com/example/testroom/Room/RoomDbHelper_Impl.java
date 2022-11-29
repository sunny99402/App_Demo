package com.example.testroom.Room;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RoomDbHelper_Impl extends RoomDbHelper {
  private volatile RoomDao _roomDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `bpm_entity` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `USER_NUMBER` TEXT NOT NULL, `ACCOUNT_ID` TEXT NOT NULL, `SYS` INTEGER NOT NULL, `DIA` INTEGER NOT NULL, `PUL` INTEGER NOT NULL, `DATE` TEXT NOT NULL, `AM__PM` TEXT, `AFIB` INTEGER NOT NULL, `PAD` INTEGER NOT NULL, `MAN` INTEGER NOT NULL, `CUFFOKR` INTEGER NOT NULL, `PHOTO_PATH` TEXT, `NOTE` TEXT, `RECORDING_PATH` TEXT, `RECORD_TIME` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ae8eb84f477b037d69d386522610adf3')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `bpm_entity`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsBpmEntity = new HashMap<String, TableInfo.Column>(16);
        _columnsBpmEntity.put("_id", new TableInfo.Column("_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpmEntity.put("USER_NUMBER", new TableInfo.Column("USER_NUMBER", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpmEntity.put("ACCOUNT_ID", new TableInfo.Column("ACCOUNT_ID", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpmEntity.put("SYS", new TableInfo.Column("SYS", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpmEntity.put("DIA", new TableInfo.Column("DIA", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpmEntity.put("PUL", new TableInfo.Column("PUL", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpmEntity.put("DATE", new TableInfo.Column("DATE", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpmEntity.put("AM__PM", new TableInfo.Column("AM__PM", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpmEntity.put("AFIB", new TableInfo.Column("AFIB", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpmEntity.put("PAD", new TableInfo.Column("PAD", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpmEntity.put("MAN", new TableInfo.Column("MAN", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpmEntity.put("CUFFOKR", new TableInfo.Column("CUFFOKR", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpmEntity.put("PHOTO_PATH", new TableInfo.Column("PHOTO_PATH", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpmEntity.put("NOTE", new TableInfo.Column("NOTE", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpmEntity.put("RECORDING_PATH", new TableInfo.Column("RECORDING_PATH", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpmEntity.put("RECORD_TIME", new TableInfo.Column("RECORD_TIME", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBpmEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBpmEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBpmEntity = new TableInfo("bpm_entity", _columnsBpmEntity, _foreignKeysBpmEntity, _indicesBpmEntity);
        final TableInfo _existingBpmEntity = TableInfo.read(_db, "bpm_entity");
        if (! _infoBpmEntity.equals(_existingBpmEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "bpm_entity(com.example.testroom.Room.RoomEntity).\n"
                  + " Expected:\n" + _infoBpmEntity + "\n"
                  + " Found:\n" + _existingBpmEntity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "ae8eb84f477b037d69d386522610adf3", "16a23cbe834bd5fdafe0ec09a067b8fd");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "bpm_entity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `bpm_entity`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(RoomDao.class, RoomDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public RoomDao getRoomDao() {
    if (_roomDao != null) {
      return _roomDao;
    } else {
      synchronized(this) {
        if(_roomDao == null) {
          _roomDao = new RoomDao_Impl(this);
        }
        return _roomDao;
      }
    }
  }
}

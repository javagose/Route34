package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerUnregistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.request.GetSyncInfoRequest;
import com.google.android.gms.fitness.request.ReadRawRequest;
import com.google.android.gms.fitness.request.ReadStatsRequest;
import com.google.android.gms.vision.barcode.Barcode;

public interface zzom extends IInterface {

    public static abstract class zza extends Binder implements zzom {

        private static class zza implements zzom {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(DailyTotalRequest dailyTotalRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dailyTotalRequest != null) {
                        obtain.writeInt(1);
                        dailyTotalRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataDeleteRequest dataDeleteRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataDeleteRequest != null) {
                        obtain.writeInt(1);
                        dataDeleteRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataInsertRequest dataInsertRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataInsertRequest != null) {
                        obtain.writeInt(1);
                        dataInsertRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataReadRequest dataReadRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataReadRequest != null) {
                        obtain.writeInt(1);
                        dataReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataUpdateListenerRegistrationRequest != null) {
                        obtain.writeInt(1);
                        dataUpdateListenerRegistrationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataUpdateListenerUnregistrationRequest dataUpdateListenerUnregistrationRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataUpdateListenerUnregistrationRequest != null) {
                        obtain.writeInt(1);
                        dataUpdateListenerUnregistrationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataUpdateRequest dataUpdateRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataUpdateRequest != null) {
                        obtain.writeInt(1);
                        dataUpdateRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetSyncInfoRequest getSyncInfoRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (getSyncInfoRequest != null) {
                        obtain.writeInt(1);
                        getSyncInfoRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ReadRawRequest readRawRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (readRawRequest != null) {
                        obtain.writeInt(1);
                        readRawRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ReadStatsRequest readStatsRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (readStatsRequest != null) {
                        obtain.writeInt(1);
                        readStatsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(DataInsertRequest dataInsertRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataInsertRequest != null) {
                        obtain.writeInt(1);
                        dataInsertRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzom zzbH(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzom)) ? new zza(iBinder) : (zzom) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            DataUpdateListenerUnregistrationRequest dataUpdateListenerUnregistrationRequest = null;
            DataInsertRequest dataInsertRequest;
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    DataReadRequest dataReadRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (data.readInt() != 0) {
                        dataReadRequest = (DataReadRequest) DataReadRequest.CREATOR.createFromParcel(data);
                    }
                    zza(dataReadRequest);
                    reply.writeNoException();
                    return true;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (data.readInt() != 0) {
                        dataInsertRequest = (DataInsertRequest) DataInsertRequest.CREATOR.createFromParcel(data);
                    }
                    zza(dataInsertRequest);
                    reply.writeNoException();
                    return true;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    DataDeleteRequest dataDeleteRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (data.readInt() != 0) {
                        dataDeleteRequest = (DataDeleteRequest) DataDeleteRequest.CREATOR.createFromParcel(data);
                    }
                    zza(dataDeleteRequest);
                    reply.writeNoException();
                    return true;
                case Barcode.PHONE /*4*/:
                    GetSyncInfoRequest getSyncInfoRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (data.readInt() != 0) {
                        getSyncInfoRequest = (GetSyncInfoRequest) GetSyncInfoRequest.CREATOR.createFromParcel(data);
                    }
                    zza(getSyncInfoRequest);
                    reply.writeNoException();
                    return true;
                case Barcode.PRODUCT /*5*/:
                    ReadStatsRequest readStatsRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (data.readInt() != 0) {
                        readStatsRequest = (ReadStatsRequest) ReadStatsRequest.CREATOR.createFromParcel(data);
                    }
                    zza(readStatsRequest);
                    reply.writeNoException();
                    return true;
                case Barcode.SMS /*6*/:
                    ReadRawRequest readRawRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (data.readInt() != 0) {
                        readRawRequest = (ReadRawRequest) ReadRawRequest.CREATOR.createFromParcel(data);
                    }
                    zza(readRawRequest);
                    reply.writeNoException();
                    return true;
                case Barcode.TEXT /*7*/:
                    DailyTotalRequest dailyTotalRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (data.readInt() != 0) {
                        dailyTotalRequest = (DailyTotalRequest) DailyTotalRequest.CREATOR.createFromParcel(data);
                    }
                    zza(dailyTotalRequest);
                    reply.writeNoException();
                    return true;
                case Barcode.URL /*8*/:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (data.readInt() != 0) {
                        dataInsertRequest = (DataInsertRequest) DataInsertRequest.CREATOR.createFromParcel(data);
                    }
                    zzb(dataInsertRequest);
                    reply.writeNoException();
                    return true;
                case Barcode.WIFI /*9*/:
                    DataUpdateRequest dataUpdateRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (data.readInt() != 0) {
                        dataUpdateRequest = (DataUpdateRequest) DataUpdateRequest.CREATOR.createFromParcel(data);
                    }
                    zza(dataUpdateRequest);
                    reply.writeNoException();
                    return true;
                case Barcode.GEO /*10*/:
                    DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (data.readInt() != 0) {
                        dataUpdateListenerRegistrationRequest = (DataUpdateListenerRegistrationRequest) DataUpdateListenerRegistrationRequest.CREATOR.createFromParcel(data);
                    }
                    zza(dataUpdateListenerRegistrationRequest);
                    reply.writeNoException();
                    return true;
                case Barcode.CALENDAR_EVENT /*11*/:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (data.readInt() != 0) {
                        dataUpdateListenerUnregistrationRequest = (DataUpdateListenerUnregistrationRequest) DataUpdateListenerUnregistrationRequest.CREATOR.createFromParcel(data);
                    }
                    zza(dataUpdateListenerUnregistrationRequest);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(DailyTotalRequest dailyTotalRequest) throws RemoteException;

    void zza(DataDeleteRequest dataDeleteRequest) throws RemoteException;

    void zza(DataInsertRequest dataInsertRequest) throws RemoteException;

    void zza(DataReadRequest dataReadRequest) throws RemoteException;

    void zza(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest) throws RemoteException;

    void zza(DataUpdateListenerUnregistrationRequest dataUpdateListenerUnregistrationRequest) throws RemoteException;

    void zza(DataUpdateRequest dataUpdateRequest) throws RemoteException;

    void zza(GetSyncInfoRequest getSyncInfoRequest) throws RemoteException;

    void zza(ReadRawRequest readRawRequest) throws RemoteException;

    void zza(ReadStatsRequest readStatsRequest) throws RemoteException;

    void zzb(DataInsertRequest dataInsertRequest) throws RemoteException;
}

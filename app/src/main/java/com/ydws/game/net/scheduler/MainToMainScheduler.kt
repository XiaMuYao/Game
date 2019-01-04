package com.ydws.game.net.scheduler

import io.reactivex.android.schedulers.AndroidSchedulers


class MainToMainScheduler<T> : BaseScheduler<T>(AndroidSchedulers.mainThread(), AndroidSchedulers.mainThread())

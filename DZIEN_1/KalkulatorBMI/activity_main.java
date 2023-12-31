<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <TextView
            android:id="@+id/textView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="KALKULATOR BMI" />

        <TextView
            android:id="@+id/textView2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="podaj masę ciała w kg" />

        <EditText
            android:id="@+id/etMasa"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="text"
            tools:ignore="SpeakableTextPresentCheck,TouchTargetSizeCheck" />

        <TextView
            android:id="@+id/textView3"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="podaj wzrost w cm" />

        <EditText
            android:id="@+id/etWzrost"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="text"
            tools:ignore="SpeakableTextPresentCheck,TouchTargetSizeCheck" />

        <Button
            android:id="@+id/btnBMI"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="policz BMI" />

        <TextView
            android:id="@+id/wynik"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

        <TextView
            android:id="@+id/opis"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />
    </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>

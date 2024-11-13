package com.example.livedata;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

public class EntrenadorViewModel extends AndroidViewModel {
    private final Entrenador entrenador;

    private final LiveData<Integer> ejercicioLiveData;
    private final LiveData<String> repeticionLiveData;

    private String ejercicioAnterior = "";

    public EntrenadorViewModel(@NonNull Application application) {
        super(application);

        entrenador = new Entrenador();

        ejercicioLiveData = Transformations.switchMap(entrenador.ordenLiveData, orden -> {
            String ejercicio = orden.split(":")[0];
            int imagen;

            // Actualiza solo si el ejercicio es diferente al anterior
            if (!ejercicio.equals(ejercicioAnterior)) {
                ejercicioAnterior = ejercicio;
                switch (ejercicio) {
                    case "EJERCICIO1":
                        imagen = R.drawable.e1;
                        break;
                    case "EJERCICIO2":
                        imagen = R.drawable.e2;
                        break;
                    case "EJERCICIO3":
                        imagen = R.drawable.e3;
                        break;
                    case "EJERCICIO4":
                        imagen = R.drawable.e4;
                        break;
                    default:
                        imagen = R.drawable.e1;
                        break;
                }
                return new MutableLiveData<>(imagen);
            }
            return null;
        });

        repeticionLiveData = Transformations.switchMap(entrenador.ordenLiveData, orden ->
                new MutableLiveData<>(orden.split(":")[1])
        );
    }

    public LiveData<Integer> obtenerEjercicio() {
        return ejercicioLiveData;
    }

    public LiveData<String> obtenerRepeticion() {
        return repeticionLiveData;
    }
}

import com.squareup.moshi.Moshi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.GET;

import java.util.ArrayList;
import java.util.List;


public class ReadJsonWithMoshi {
    public static void main(String[] args) {

        Moshi moshi = new Moshi.Builder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:3000/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build();

        PharmacyService service = retrofit.create(PharmacyService.class);

        service.getPharmacies().enqueue(new Callback<List<Farmacias>>() {
            @Override
            public void onResponse(Call<List<Farmacias>> call, Response<List<Farmacias>> response) {
                System.out.println(response.body());
                List<Pharmacy> innerPharmacyList = parsePharmacies(response.body());
            }

            @Override
            public void onFailure(Call<List<Farmacias>> call, Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        });
    }

    private static List<Pharmacy> parsePharmacies(String responseString) {
        ArrayList<Pharmacy> pharmacyArrayList = new ArrayList<>();
        try {
            JSONArray pharmacyJSONArray = new JSONArray(responseString);
            for (int i = 0; i < pharmacyJSONArray.length(); i++) {
                JSONObject pharmacyJSON = pharmacyJSONArray.getJSONObject(i);
                String name = pharmacyJSON.getString("name");
                String address = pharmacyJSON.getString("address");
                Pharmacy pharmacy = new Pharmacy(name, address, "", "", "", "");
                System.out.println(pharmacy.toString());
                pharmacyArrayList.add(pharmacy);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return pharmacyArrayList;
    }


    private static List<Pharmacy> parsePharmacies(List<Farmacias> farma) {
        ArrayList<Pharmacy> pharmacyArrayList = new ArrayList<>();
        for (Farmacias f: farma) {
            Pharmacy pharmacy = new Pharmacy(f.getName(), f.getAddress(), f.getGeolocation().toString(), "", f.getExtra().toString(), "");
            pharmacyArrayList.add(pharmacy);
        }
        return pharmacyArrayList;
    }

    interface PharmacyService {
        @GET("farmacias")
        Call<List<Farmacias>> getPharmacies();
    }
}

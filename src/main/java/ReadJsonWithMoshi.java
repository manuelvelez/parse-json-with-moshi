
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ReadJsonWithMoshi {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:3000/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        PharmacyService service = retrofit.create(PharmacyService.class);

        service.getPharmacies().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                List<Pharmacy> innerPharmacyList = parsePharmacies(response.body());
//                pharmacyList.setValue(innerPharmacyList);
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {
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

    interface PharmacyService {
        @GET("farmacias")
        Call<String> getPharmacies();
    }
}

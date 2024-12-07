<template>
    <div>
        <h1>Blood Bank Query</h1>
        <p>This is the blood bank query page.</p>
    </div>
</template>
<script>
import BloodBankapi from "@/api/BloodBankapi";

export default {
    name: "BloodQuery",
    data() {
        return {
            bloodBanks: []
        };
    },
    created() {
        BloodBankapi.getPage({}).then(response => {
            this.bloodBanks = response.data;
            console.log(this.bloodBanks);
        });
    }
};
</script>

package com.appstcit.banglawordbook;

import android.widget.Toast;

/**
 * Created by Bj on 25-12-17.
 */

public class Test {
final static     String[] biologyBangla={"পরিশোষণ", "বর্ণ কারবিহীন", "উপোযোগী করা", "বায়ুজীবী", "শেওলাগুলি", "খাদ্য সংক্রান্ত", "রোগ বিশেষ", "আদ্য প্রাণী", "ঊভচর প্রানী", "শব্দ", "শরীরবিদ্যা", "পূর্ব পুরুষ", "প্রোটিনজাতিও পদার্থ যা ক্ষতিকর পদার্থ কে নিষ্কিয় করে", "লেজুড়", "জলচর", "ব্রাক্ষ", "অযৌন", "পরিপাক", "অবক্ষয়", "শ্রোত বর্গ", "শিঢ়দাতা", "রোগ জীবানু",  "দাড়িপাল্লা", "বেড়া", "প্রশন্ন", "জীববিদ্যা", "বায়োম",
            "দুই ভাগে ভাগ করা", "উদ্ভিদ বিজ্ঞান", "শ্বাস-প্রশ্বাস নেওয়া", "মাংসাসী", "অনুঘটক", "খোল", "জেলে", "যে উপাদানে পাতার রঙ সবুজ হয়", "কলেস্টেরল", "বর্ণ ময়", "ক্রোমোসোম",  "নেত্তলোম", "শ্রেনী বিভাগ", "সংযোজনশীল", "কোলাজেন", "জ্ঞাপনীয়", "সম্প্রদায়", "সংকোচন", "দমন করা", "মোচড়ানো", "হৃৎপিণ্ড রক্ত সঞ্চালক শিরা", "ইংরেজী প্রকৃতিবাদী", "অপম্রিয়মান", "পচানি", "অন্তস্ত্বক", "বেড়ে উঠা", "বিররীত মুখি", "পথ্য সম্বন্ধীয়", "বিভেদ", "প্রচার প্রশারন", "পরিপাক","প্রাগ্রেতিহাসিক অতিকায় সরীসৃপ", "সংযম", "স্থানচ্যুতি", "বিভাগ", "ডিএনএ", "কৃতিত্বপুণ্য", "সুপ্ত", "বাস্তব বিদ্যা", "বাস্ত", "জীবকোষের বরিরারনণ", "শোথ", "ভ্রুন", "আপন্ন",
            "দেশগত", "শক্তি", "পরিবেশ", "প্রাচীর জীবন্ত কোষে উৎপন্ন রাসায়নিক পদাওরথবিশেষ", "বহিত্বক", "ক্ষয়", "অতযাবশ্যকীয়", "ইস্টজেন", "ক্রমবিকাশ", "উস্নুলন", "অধুনালুপ্ত", "অন্যতম হেতু", "পুনর্নিবেশ", "গর্ভাধান", "ভ্রুন", "সুক্ষ", "মাছ", "বিভিন্ন অংশের ভজ্ঞকরন", "জীবাশ্ম", "বিশেষ", "জননকোষ", "গ্যাস পূর্ণ", "প্রজননশাস্র", "জিনোম", "মহাজাতি",
            "বীজ", "গর্ভ ধারনকাল", "কোদাল", "জন্ম", "জন্তর", "হিমোগ্লোবিন", "তৃণভোজীপ্রানী", "বংশের ধারা", "বিবিধ জাতীয় পদার্থ", "শীতযাপনতা", "ঘাজকগন", "সমজাতীয়", "শরীরের ভেতরের যে রশ রক্তের সাথে মিশে শরীর কে কার্যক্রম করে", "উদ্যান পালন বিদ্যা", "নিয়ন্ত্রণ কর্তা", "সহুদয়", "দোঁআশলা", "রোগসুংক্রামন থেকে নিরাপত্তা", "অন্তর্ভুক্তি", "ডিমের উপর বসা", "আহার", "টিকা দেওয়া", "তদন্ত", "অদ্রবনীয়", "প্রেরনা", "ইন্সুলিন", "পরস্পর নির্ভয়শীল","অমেরুদণ্ডী", "ইচ্ছা নয় এমন", "বিচ্ছিন্ন করা", "আইসো্টোপ", "সন্ধিক্ষন", "রাজ্য", "অক্ষরেখা", "গাছের পাথা", "জীবনচক্র", "দুটো ঘটনার", "জীবিকা", "আলোকউৎসাহী", "লসিকা", "বিদ্বেশপূর্ণ",
            "স্তন্যপায়ী", "সামুদ্রিক", "একশ্রেণীর অর্থালংকার", "প্রানী", "স্মরনকাল", "জীবদেহের রাসায়নিক রুপান্তর", "জীবার্ণুবিজ্ঞান", "অণুবিক্ষণ যন্ত্র", "অভিপ্রয়অণ", "চিতা", "ঝরান", "মাংসপেশী", "নামজার", "পারস্পরিক মজ্ঞলজনক সহ্যবস্থান", "স্বাভাবিক", "স্লায়ু", "স্নায়ুকোষ ও তার শাখাপ্রশখা", "নাইট্রোজেন",  "কোষকেন্দ্র যে কেন্দ্রী অংশের চারপাশে অপরাপর অংশ গুলো জড়ো হয়", "সর্বভোগ", "দৃষ্ট্রি", "ক্রম", "অভিস্রাবণ", "অস্মীভবণ", "অগুপ্রসূ", "জারণ", "জীবাশ্মবিদ", "পরাভুক প্রানী", "রোগজনক শক্তি",

            "প্রবেশ্য ভেদ্য", "সালোকসংশ্লেষন", "সমুদ্র নদী জলে ভাসন্ত", "রক্তরস", "প্লেটলেট", "পরাগ", "অবিশুদ্ধতা", "অংশ", "প্রানীদের", "সংরক্ষণ করা", "চাপ", "পন্যদ্রব্য উৎপাদত্তপাদক", "প্রোটিন", "জীবনের মূলীভূত উপাদান", "ফুসফুস সংক্রান্ত", "প্রাচীন পিরামিড", "অনুসন্ধান", "প্রশ্ন", "অরীয়", "রিসেপটর", "পিছু হটে যাবার", "পূর্ণব্যবহারযোগ্য", "প্রতিফলিত", "নবপ্রেরণা লাভ", "বিধি", "উল্টোদিকে মুড়ানো", "দমন করা", "যে সব প্রাণী বুকে ভর দিয়ে চলে", " অবশিষ্ট", "উপায় সম্ভাবনা", "শ্বাস", "বাধা", "শিকড়", "কর্ম পরিধি", "গোপন করা", "বীজ", "সেন্সর", "কঙ্কাল", "খোসা", " সৌর", "দূরত্ব সংক্রান্ত", "কুল", "নমুনা","প্রমানিত তথ্যাবলী","উদ্দীপনা",
            "জোর", "গঠন"," জীবনযাপন", "প্রতিসাম্য", "পান্ত সন্নিকর্ষ", "পদ্ধতি", "স্বাদ", "শ্রেনীবিন্যাস", "শূয়া", "পার্থিব", "তত্ত্ব", "সহনশীলতা", "উপবিষ", "রুপান্তর", "ত্বক দিয়া নিঃসরণ", "উত্তর মেরু অঞ্চলের বরফ্রাই", "স্ফীট", "অপরিপৃক্ত", "দেহাবয়বে বায়ু", "ভিন্নতা", "বায়ু চলাচল করানো", "মেরুদন্ডী","টিকে থাকতে সক্ষম এমন","সংক্রামক রোগের অদৃশ্য জীবানু বিশেষ",

            "প্রোয়োজনীয়", "ভিটামিন","ডিমের বদলে শাবক প্রসবকারিণী", "পুস্তক", "স্বেচ্ছাকৃত", " অকেজো", "জলবায়ু", "মেখলা", "প্রাণীবিদ্যা"};
final static    String[] biologyEnglish={"Absorption","Achromatic","Adaptation","Aerobic","Algae","Alimentary","Allergy","Amoeba","Amphibian","Analogue","Anatomy","Ancestor","Antibody","Appendage","Aquatic","Arboreal","Asexual","Assimilation","Atrophy","Auditory","Backbone","Bacteria","Balance","Barrier","Benign","Biology","Biome","Bisect","Botany","Branch","Breathe","Carnivorous","Catalyst","Cavity","Cell","Chlorophyll","Cholesterol","Chromatic","Choromosome","Cilia","Classification","Cohesive","Collagen","Communicable","Community","Contraction","Control","Convolution","Coronary","Cyclic","Darwin","Deciduous","Decomposition","Dermis","Develop","Dichotomous","Dietary","Differentiation","Diffusion","Digestion","Dinosaur","Discipline","Displacement","Division","Dna","Dominent","Dormant","Ecology","Ecosystem","Ectoplasm","Edema","Embryo","Endengered", "Endemic","Energy","Environment","Enzyme","Epidermis","Erosion","Essential","Estrogen","Evolution","Extermination","Extinct","Factor","Feedback","Fertilization","Fetus","Filament", "Fish","Fission","Fossil","Function","Gamete","Gaseous","Genetics","Genome","Genus","Germ","Gestation","Grafting","Growth","Habitat","Hemoglobin","Herbivore", "Heredity","Heterogenous","Hibernation","Hierarchy","Homogeneous","Hormone","Horticulture","Host","Human","Human","Hybrid","Immunity","Inclusion","Incubate","Ingestion","Inoculate","Inquiry","Insoluble","Instinct","Insulate","Insulin","Interdependent","Invertebrate","Involuntary","Isolate","Isotope","Juncture","Kingdom","Latitude","Leaf","Lifecycle","Linkage","Living","Luminescent","Lymph","Malignant","Mammal","Marine","Meiosis","Membrane","Memory", "Metabolism","Microbiology","Microscope","Migration","Mildew","Molt","Muscle","Mutation","Mutualism","Natural","Nerve","Neuron","Nitrogen","Nucleus","Omnivorous","Optic","Order","Osmosis","Ossification","Oviparous","Oxidation","Paleontologist","Parasite","Pathogen","Permeable", "Photosynthesis","Plankton","Plasma","Platlet","Pollen"," Pollution","Portion","Predator","Preserve","Pressure","Producer","protein","Protoplasm","Pulmonary","Pyramid","Quest", "Question","Radial","Receptor","Recessive","Recycling","Reflex","Regeneration","Regulate","Replicate","Repress","Reptile","Residual","Resource","Respiration","Restriction","Root", "Scope","Secrete","Seed","Sensor","Shelter","Skeleton","Skin","Soler","Spatial","Species","Specimen","Statistics","Stimulus","Stress","Structure","Symbiosis","Symmetry","Synapse","System","Taste","Taxonomy","Tendril","Terrestrial","Tissue","Tolerance", "Toxin","Transformation","Transpiration","Tundra","Turgid","Unsaturated","vacuole","Variation","Ventilate","Vertebrate","Viable","Virus","Vital","Vitamin","Viviparous","Volume"};

    public static void main(String[] arg){

       System.out.printf(biologyBangla.length+"english length"+ biologyEnglish.length);
    }
}

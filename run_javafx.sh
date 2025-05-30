
JAVAFX_SDK_LIB_PATH="/Users/winson/Desktop/javafx-sdk-21.0.7/lib"

if [ "${JAVAFX_SDK_LIB_PATH}" == "/PATH/TO/YOUR/JAVAFX_SDK_LIB" ] || [ ! -d "${JAVAFX_SDK_LIB_PATH}" ]; then
    echo "ERROR: Path ke JavaFX SDK lib (JAVAFX_SDK_LIB_PATH=\"${JAVAFX_SDK_LIB_PATH}\") tidak valid atau bukan direktori."
    echo "Pastikan path tersebut benar dan merupakan direktori 'lib' dari JavaFX SDK Anda."
    exit 1
fi

SOURCE_DIR="src/main/java"
CLASSES_DIR="target/classes"
MAIN_CLASS_APP="com.physics.calculator.GravitationalForceApp"

JAVAFX_MODULES="javafx.controls,javafx.fxml,javafx.web"

mkdir -p "${CLASSES_DIR}"

find "${CLASSES_DIR}" -name '*.class' -delete

echo "Mengkompilasi kode sumber..."

javac --module-path "${JAVAFX_SDK_LIB_PATH}" \
      --add-modules "${JAVAFX_MODULES}" \
      -d "${CLASSES_DIR}" \
      $(find "${SOURCE_DIR}" -name '*.java')

if [ $? -ne 0 ]; then
    echo "ERROR: Kompilasi gagal."
    exit 1
fi

echo "Kompilasi berhasil."
echo "Menjalankan aplikasi ${MAIN_CLASS_APP}..."

java --module-path "${JAVAFX_SDK_LIB_PATH}" \
     --add-modules "${JAVAFX_MODULES}" \
     -cp "${CLASSES_DIR}" \
     "${MAIN_CLASS_APP}"

echo "Aplikasi ditutup." 
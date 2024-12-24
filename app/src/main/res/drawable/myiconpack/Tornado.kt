package myiconpack

import MyIconPack
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.StrokeJoin.Companion.Round
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val MyIconPack.Tornado: ImageVector
    get() {
        if (_tornado != null) {
            return _tornado!!
        }
        _tornado = Builder(name = "Tornado", defaultWidth = 56.0.dp, defaultHeight = 48.0.dp,
                viewportWidth = 56.0f, viewportHeight = 48.0f).apply {
            path(fill = SolidColor(Color(0xFF1d1d1d)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveToRelative(20.2395f, 27.0f)
                horizontalLineToRelative(2.1597f)
                curveToRelative(1.403f, 0.0f, 2.7694f, 0.4481f, 3.9f, 1.279f)
                lineToRelative(0.0749f, 0.0551f)
                curveToRelative(0.8479f, 0.6232f, 1.0301f, 1.8158f, 0.4069f, 2.6637f)
                curveToRelative(-0.0627f, 0.0853f, -0.1325f, 0.1653f, -0.2085f, 0.2391f)
                lineToRelative(-2.8266f, 2.7425f)
                curveToRelative(-1.0913f, 1.0589f, -1.8597f, 2.4058f, -2.2157f, 3.8841f)
                curveToRelative(-0.355f, 1.4743f, -1.1473f, 2.8068f, -2.2729f, 3.823f)
                lineToRelative(-3.1203f, 2.8168f)
                lineToRelative(-1.9597f, 1.3737f)
                curveToRelative(-0.8568f, 0.6006f, -2.0382f, 0.3929f, -2.6388f, -0.4639f)
                curveToRelative(-0.5411f, -0.7719f, -0.4324f, -1.8242f, 0.2552f, -2.4692f)
                lineToRelative(1.0781f, -0.9966f)
                curveToRelative(1.2556f, -1.1607f, 1.9695f, -2.793f, 1.9695f, -4.5029f)
                curveToRelative(0.0f, -1.7724f, -0.3325f, -3.529f, -0.9802f, -5.1788f)
                lineToRelative(-1.5105f, -3.8473f)
                curveToRelative(-0.2097f, -0.534f, 0.0533f, -1.1369f, 0.5873f, -1.3465f)
                curveToRelative(0.1209f, -0.0475f, 0.2497f, -0.0719f, 0.3796f, -0.0719f)
                horizontalLineToRelative(6.922f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.2f, strokeLineCap = Butt, strokeLineJoin = Round,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveToRelative(34.6205f, 12.24f)
                curveToRelative(0.0f, -2.76f, -2.22f, -4.92f, -4.92f, -4.92f)
                curveToRelative(-0.6f, 0.0f, -1.14f, 0.12f, -1.68f, 0.3f)
                curveToRelative(-0.18f, -2.04f, -1.86f, -3.72f, -3.96f, -3.72f)
                curveToRelative(-2.22f, 0.0f, -4.02f, 1.8f, -4.02f, 4.02f)
                curveToRelative(0.0f, 0.48f, 0.12f, 0.96f, 0.24f, 1.38f)
                curveToRelative(-0.18f, -0.06f, -0.42f, -0.06f, -0.6f, -0.06f)
                curveToRelative(-2.22f, 0.0f, -4.02f, 1.8f, -4.02f, 4.02f)
                curveToRelative(0.0f, 2.16f, 1.74f, 3.96f, 3.9f, 4.02f)
                lineToRelative(10.32f, 0.0f)
                curveToRelative(2.64f, -0.3f, 4.74f, -2.4f, 4.74f, -5.04f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.2f, strokeLineCap = Butt, strokeLineJoin = Round,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveToRelative(43.7005f, 21.4f)
                curveToRelative(0.0f, -4.6f, -3.7f, -8.2f, -8.2f, -8.2f)
                curveToRelative(-1.0f, 0.0f, -1.9f, 0.2f, -2.8f, 0.5f)
                curveToRelative(-0.3f, -3.4f, -3.1f, -6.2f, -6.6f, -6.2f)
                curveToRelative(-3.7f, 0.0f, -6.7f, 3.0f, -6.7f, 6.7f)
                curveToRelative(0.0f, 0.8f, 0.2f, 1.6f, 0.4f, 2.3f)
                curveToRelative(-0.3f, -0.1f, -0.7f, -0.1f, -1.0f, -0.1f)
                curveToRelative(-3.7f, 0.0f, -6.7f, 3.0f, -6.7f, 6.7f)
                curveToRelative(0.0f, 3.6f, 2.9f, 6.6f, 6.5f, 6.7f)
                horizontalLineToRelative(17.2f)
                curveToRelative(4.4f, -0.5f, 7.9f, -4.0f, 7.9f, -8.4f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffa500)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(25.3205f, 33.28f)
                lineToRelative(3.84f, -11.76f)
                lineToRelative(7.44f, 0.0f)
                lineToRelative(-4.92f, 8.64f)
                lineToRelative(4.68f, 0.0f)
                lineToRelative(-10.56f, 12.36f)
                lineToRelative(4.08f, -9.24f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveToRelative(43.7796f, 29.906f)
                lineToRelative(-5.9912f, 10.117f)
                curveToRelative(-0.5628f, 0.9504f, -0.2486f, 2.1772f, 0.7018f, 2.74f)
                curveToRelative(0.3085f, 0.1827f, 0.6605f, 0.2791f, 1.0191f, 0.2791f)
                horizontalLineToRelative(11.982f)
                curveToRelative(1.1046f, 0.0f, 2.0f, -0.8954f, 2.0f, -2.0f)
                curveToRelative(0.0f, -0.3586f, -0.0964f, -0.7106f, -0.2791f, -1.0191f)
                lineToRelative(-5.9912f, -10.117f)
                curveToRelative(-0.5628f, -0.9504f, -1.7896f, -1.2646f, -2.74f, -0.7018f)
                curveToRelative(-0.2892f, 0.1713f, -0.5306f, 0.4126f, -0.7018f, 0.7018f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.5f, strokeLineCap = StrokeCap.Companion.Round,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveToRelative(45.5005f, 37.5f)
                verticalLineToRelative(-5.0f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(45.5005f, 40.0f)
                moveToRelative(-1.0f, 0.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, true, true, 2.0f, 0.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, true, true, -2.0f, 0.0f)
            }
        }
        .build()
        return _tornado!!
    }

private var _tornado: ImageVector? = null

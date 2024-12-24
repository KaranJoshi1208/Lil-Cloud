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

public val MyIconPack.Thunderstorms: ImageVector
    get() {
        if (_thunderstorms != null) {
            return _thunderstorms!!
        }
        _thunderstorms = Builder(name = "Thunderstorms", defaultWidth = 56.0.dp, defaultHeight =
                48.0.dp, viewportWidth = 56.0f, viewportHeight = 48.0f).apply {
            path(fill = SolidColor(Color(0xFF91c0f8)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.2f, strokeLineCap = Butt, strokeLineJoin = Round,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveToRelative(34.62f, 13.24f)
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
            path(fill = SolidColor(Color(0xFF57a0ee)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.2f, strokeLineCap = Butt, strokeLineJoin = Round,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveToRelative(43.7f, 22.4f)
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
                moveTo(25.32f, 34.28f)
                lineToRelative(3.84f, -11.76f)
                lineToRelative(7.44f, 0.0f)
                lineToRelative(-4.92f, 8.64f)
                lineToRelative(4.68f, 0.0f)
                lineToRelative(-10.56f, 12.36f)
                lineToRelative(4.08f, -9.24f)
                close()
            }
        }
        .build()
        return _thunderstorms!!
    }

private var _thunderstorms: ImageVector? = null
